package org.aprsdroid.app

import _root_.android.app.Activity
import _root_.android.content.Context
import _root_.android.os.{Build, Bundle}
import _root_.android.text.{Editable, TextWatcher}
import _root_.android.view.{View, ViewGroup}
import _root_.android.util.TypedValue
import _root_.android.widget.{AbsListView, AdapterView, BaseAdapter, Button, EditText, ImageView, GridView}
import _root_.android.widget.AdapterView.OnItemClickListener
import androidx.core.view.WindowCompat

class PrefSymbolAct extends Activity with TextWatcher with View.OnClickListener {
	lazy val overlayedit = findViewById(R.id.overlay).asInstanceOf[EditText]
	lazy val symbolview = findViewById(R.id.symbol).asInstanceOf[SymbolView]
	lazy val okbutton = findViewById(R.id.ok).asInstanceOf[Button]
	lazy val prefs = new PrefsWrapper(this)
	var chosen_sym : String = ""

	val OVERLAYABLE = "#&0>A^_acnsuvz"

	def overlayAllowed(symbol : String) = {
		symbol(0) != '/' && OVERLAYABLE.contains(symbol(1))
	}

	def setSymbol(symbol : String) {
		val ov_en = overlayAllowed(symbol)
		overlayedit.setEnabled(ov_en)

		val ov = overlayedit.getText().toString()
		if (ov_en && (ov.length == 1)) {
			chosen_sym = "%c%c".format(ov(0), symbol(1))
		} else {
			chosen_sym = symbol
		}
		if (chosen_sym.length == 2)
			symbolview.setSymbol(chosen_sym)
		else symbolview.setSymbol("/$")
	}

	override def onCreate(savedInstanceState: Bundle) {
		super.onCreate(savedInstanceState)
		// Enable edge-to-edge so the system does NOT auto-apply insets to
		// the decor view. We apply insets manually via the listener below.
		// Using setDecorFitsSystemWindows(true) would cause double padding
		// (system insets + our manual padding) on stock Android 15/16.
		if (Build.VERSION.SDK_INT >= 30) {
			getWindow().setDecorFitsSystemWindows(false)
		} else {
			WindowCompat.setDecorFitsSystemWindows(getWindow(), false)
		}
		setContentView(R.layout.prefsymbol)
		// Apply WindowInsets to the root view so the GridView content is
		// not clipped by the status bar (top) and the OK button is not
		// clipped by the gesture/navigation bar (bottom) on Android 15/16.
		val root = findViewById(R.id.prefsymbol_root).asInstanceOf[View]
		if (root != null) {
			root.setOnApplyWindowInsetsListener(
				new View.OnApplyWindowInsetsListener() {
					override def onApplyWindowInsets(v : View,
							insets : android.view.WindowInsets
							) : android.view.WindowInsets = {
						var topPad = 0
						var bottomPad = 0
						var leftPad = 0
						var rightPad = 0
						if (Build.VERSION.SDK_INT >= 30) {
							val status = insets.getInsets(
								android.view.WindowInsets.Type.statusBars())
							val nav = insets.getInsets(
								android.view.WindowInsets.Type.navigationBars())
							topPad = status.top
							leftPad = status.left
							rightPad = status.right
							bottomPad = nav.bottom
						} else {
							topPad = insets.getSystemWindowInsetTop()
							leftPad = insets.getSystemWindowInsetLeft()
							rightPad = insets.getSystemWindowInsetRight()
							bottomPad = insets.getSystemWindowInsetBottom()
						}
						v.setPadding(leftPad, topPad, rightPad, bottomPad)
						insets
					}
				})
		}
		val gv = findViewById(R.id.gridview).asInstanceOf[GridView]
		gv.setAdapter(new SymbolAdapter(this))
		gv.setOnItemClickListener(new OnItemClickListener() {
				override def onItemClick(av : AdapterView[_], v : View, position : Int, id : Long) {
					android.util.Log.d("PrefSymbolAct", "tapped " + v.asInstanceOf[SymbolView].symbol)
					setSymbol(v.asInstanceOf[SymbolView].symbol)
				}})
		okbutton.setOnClickListener(this)
		chosen_sym = prefs.getString("symbol", "/$")
		if (chosen_sym.length != 2)
			chosen_sym = "/$"
		val ov = chosen_sym(0)
		if (ov != '/' && ov != '\\')
			overlayedit.setText("" + ov)
		overlayedit.addTextChangedListener(this)
		setSymbol(chosen_sym)
	}

	// OnClickListener for OK button
	def onClick(view : View) {
		prefs.prefs.edit().putString("symbol", chosen_sym).commit()
		finish()
	}

	// TextWatcher for edit
	override def afterTextChanged(s : Editable) {
		setSymbol("%c%c".format('\\', chosen_sym(1)))
	}
	override def beforeTextChanged(s : CharSequence, start : Int, before : Int, count : Int) {
	}
	override def onTextChanged(s : CharSequence, start : Int, before : Int, count : Int) {
	}


	class SymbolAdapter(context : Context) extends BaseAdapter {
		override def getCount() = 16*12 - 2

		override def getItem(position : Int) : Object = {
			val primary = position / 95
			val secondary = position%95
			return "/\\"(primary) + ('!' + secondary).asInstanceOf[Char].toString
		}

		override def getItemId(position : Int) = position.asInstanceOf[Long]

		override def getView(position : Int, convertView : View, parent : ViewGroup) : View = {
			val v = if (convertView == null) {
					val vt = new SymbolView(context, null)

					val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48,
						getResources().getDisplayMetrics()).asInstanceOf[Int]

					vt.setLayoutParams(new AbsListView.LayoutParams(px, px))
					vt.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
					//vt.setPadding(8, 8, 8, 8)
					vt
				} else convertView.asInstanceOf[SymbolView]
			v.setSymbol(getItem(position).asInstanceOf[String])
			return v
		}
	}
}
