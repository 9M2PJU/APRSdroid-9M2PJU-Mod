# 📡 NA7Q-APRSDroid 9M2PJU-Mod
### *The Ultimate APRS Companion for Android — 9M2PJU-Mod*

> 🌟 **This is the 9M2PJU-Mod** of [NA7Q's enhanced APRSdroid](https://github.com/na7q/aprsdroid),
> which is itself a fork of [Georg Lukas's original APRSdroid](https://aprsdroid.org/).
> It adds a launch splash screen, modern Android support, GitHub Actions CI/CD with
> signed release builds, and a project landing page with live download counters.

---

<div align="center">

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://aprsdroid.hamradio.my/)
[![License](https://img.shields.io/badge/License-GPLv2-blue?style=for-the-badge)](https://www.gnu.org/licenses/gpl-2.0.html)
[![Scala](https://img.shields.io/badge/Built_with-Scala-DC322F?style=for-the-badge&logo=scala&logoColor=white)](https://www.scala-lang.org/)
[![targetSdk 35](https://img.shields.io/badge/targetSdk-35_(Android_15)-CEB619?style=for-the-badge)](https://developer.android.com/about/versions/15)
[![Build](https://img.shields.io/github/actions/workflow/status/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod/build.yml?style=for-the-badge&label=CI)](https://github.com/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod/actions/workflows/build.yml)
[![Release](https://img.shields.io/github/v/release/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod?style=for-the-badge&label=Latest%20Release)](https://github.com/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod/releases/latest)
[![Downloads](https://img.shields.io/github/downloads/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod/total?style=for-the-badge&label=Total%20Downloads)](https://aprsdroid.hamradio.my/)

**[🌐 Landing Page](https://aprsdroid.hamradio.my/)** • **[⬇️ Download](https://github.com/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod/releases/latest)** • **[🗺️ Original APRSdroid](https://aprsdroid.org/)** • **[📦 Source](https://github.com/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod)**

</div>

---

## ✨ **What is NA7Q-APRSDroid 9M2PJU-Mod?**

NA7Q-APRSDroid 9M2PJU-Mod is a powerful, extensively enhanced Android client for the
[**APRS (Automatic Packet Reporting System)**](http://aprs.org/) network. It builds on
NA7Q's enhanced APRSdroid and adds modern Android compatibility, a branded splash screen,
CI/CD with signed release APKs, and a project landing page.

### 🆕 **What's new in the 9M2PJU-Mod**
- 🎨 **Branded splash screen** on cold start (matching app icon)
- 🖼️ **New app icon & logo**
- 📱 **Modern Android support** — `targetSdk 35` (Android 15), per-type foreground service
  permissions, `BLUETOOTH_SCAN`/`BLUETOOTH_CONNECT` for Android 12+, `MANAGE_EXTERNAL_STORAGE`
  for offline map files on Android 11+, `POST_NOTIFICATIONS` for Android 13+
- 🤖 **GitHub Actions CI/CD** — signed release APK builds on every push and tag, automatic
  GitHub Releases on `v*` tags
- 🌐 **GitHub Pages landing page** with live download counters (no backend — counts come
  straight from the GitHub API)
- 🏷️ **Version `v1.8`** (tocall `APDR18`)

### 🎯 **Core Features**
- 📍 **Real-time Position Reporting** — Share your location with the APRS network
- 🗺️ **Interactive Station Map** — Visualize nearby amateur radio stations with offline mapping
- 💬 **APRS Messaging** — Send and receive messages through the network
- 🔄 **Network Integration** — Full compatibility with APRS infrastructure
- 🎨 **Clean Android UI** — Holo-based interface designed for mobile use

### 🚀 **Enhanced Features (inherited from NA7Q, not in official APRSdroid)**

#### 📡 **RF & Networking**
- 🔄 **Digipeater** — Direct or full digipeating capabilities
- 🌐 **2-Way IGating** — Full Internet Gateway functionality
- 📶 **Flexible Packet Routing** — Send packets via RF and APRS-IS, or RF only while IGating
- 🎚️ **Radio Control** — Support for Vero, BTech, Radioddity, and other radios
- 📻 **DigiRig Support** — Seamless integration with DigiRig interfaces
- 🔵 **Bluetooth Low Energy** — Stable BLE support

#### 🗺️ **Advanced Offline Mapping**
- 🗺️ **Offline Maps with MBTiles** — Complete offline operation capability
- 🆕 **MapsForge V3 Support** — Enhanced offline mapping with MapsForge
- 🌍 **OpenStreetMap Integration** — Full OSM compatibility for mapping
- ⚠️ **Note**: Google Maps is optional (build from source with your own API key); the mod
  focuses on offline mapping for privacy and reduced dependencies

#### 📊 **Data & Compression**
- 🗜️ **Mic-E Compression** — Efficient position encoding
- 🚨 **Mic-E Emergency Status** — Including EMERGENCY status support
- 📈 **Standard Compression** — Multiple compression formats supported

#### ⚙️ **User Experience Enhancements**
- 📏 **Unit Options** — Choose between Metric or Imperial units
- 🔧 **Hardware Control** — Option to disable hardware acceleration
- 📊 **Enhanced Station Viewer** — Added speed and course information
- 💬 **Advanced Messaging Tweaks** — Features for power users
- 🆔 **Message ID Control** — Option to disable Message ID
- 📋 **Smart Hub Log** — Sort by distance or newest stations
- 🔍 **Under-the-Hood Improvements** — Numerous performance and stability enhancements

---

## 🚀 **Quick Start**

### 📲 **Installation**

> ⚠️ **Important**: Uninstall any previous OFFICIAL version of APRSdroid before installing
> this mod — the signing key differs, so Android will refuse an in-place upgrade.

1. **Download the latest signed release APK** from the
   [**Releases page**](https://github.com/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod/releases/latest)
   (or browse all releases + live download counts on the
   [**landing page**](https://aprsdroid.hamradio.my/))
2. **Install** the APK on your Android device (enable "Install from unknown sources" if prompted)
3. On **Android 11+**, grant *All files access* for offline MBTiles maps (see below)

### 🗺️ **Setting Up Offline Maps**

For Android 11+ devices, manual storage permissions are required for offline mapping files:

1. In APRSdroid settings, go to **OSM Maps** category
2. Tap **"Grant Storage Permissions"**
3. Grant **ALL file permissions** for device storage access
4. Set map viewer to **OpenStreetMap.org** to use offline maps
5. Configure offline maps in the **OSM Maps** preferences section

#### 🗺️ **Getting Maps**

NA7Q provides several tools for downloading offline maps:

- 🌍 [**World Map**](https://na7q.com/wp-content/uploads/2024/12/map.mbtiles) — Ready-to-use world map
- 🖥️ [**OSM Map Maker (Windows)**](https://downloads.aprs.wiki/APRSdroid/gui7-concurrency.exe) — Windows GUI tool
- 🐍 [**Python Map Maker**](https://na7q.com/wp-content/uploads/2025/01/gui7-concurrency.py) — Python script version
- 🗺️ [**Multi-Map Maker**](https://na7q.com/wp-content/uploads/2025/02/mapmaker-0.2.exe) — Advanced mapping tool
- 👁️ [**Map Viewer**](https://na7q.com/wp-content/uploads/2025/02/mapviewer.exe) — Preview downloaded maps
- 🌐 [**BBBike MapsForge**](https://extract.bbbike.org/) — Alternative map source

**Map Requirements**:
- Use **MBTiles format** (PNG or JPG, NOT Vector/PBF)
- Specify precise locations like "Portland, Oregon" or "Texas USA"
- Zoom levels 1-18 (recommend 13-14 for states)
- Note: Large areas at high zoom can be 2-5GB+

### 📚 **Documentation & Support**
- 🌐 [**9M2PJU-Mod Landing Page**](https://aprsdroid.hamradio.my/)
- 📋 [**Releases & download counters**](https://aprsdroid.hamradio.my/#download)
- 📖 [**Original APRSdroid FAQ**](https://github.com/ge0rg/aprsdroid/wiki/Frequently-Asked-Questions)
- ⚙️ [**Original APRSdroid Configuration Guide**](https://github.com/ge0rg/aprsdroid/wiki/Settings)
- 🛠️ [**NA7Q's Homepage**](https://na7q.com/aprsdroid-osm/) & [**Changelog**](https://na7q.com/aprsdroid-changelog/)

---

## 🤖 **CI/CD**

Signed release APKs are built automatically by [**GitHub Actions**](.github/workflows/build.yml):

- **On every push to `master`** — builds a signed release APK, uploads it as a workflow artifact.
- **On `v*` tags** — builds a signed release APK and publishes a GitHub Release titled
  `<tag>-9M2PJU` with the APK `NA7Q-APRSDroid-<tag>-9M2PJU.apk` attached.
- **Tests + lint** run before every build; reports are uploaded as artifacts.

Signing keys are stored as GitHub Secrets (`RELEASE_KEYSTORE_BASE64`,
`RELEASE_STORE_PASSWORD`, `RELEASE_KEY_ALIAS`, `RELEASE_KEY_PASSWORD`). See
[`AGENTS.md`](AGENTS.md) §8 for the full setup if you want to reproduce signing locally.

---

## 🛠️ **Development & Compilation**

### 🏗️ **Build Environment**
APRSdroid is crafted in **Scala 2.11** using the
[gradle-android-scala-plugin](https://github.com/AllBus/scala-plugin). Notes:
- ⏱️ Full builds take approximately **3 minutes**
- 🔄 Incremental builds may occasionally produce non-functional APKs — clean when in doubt
- 🗺️ **Google Maps API key optional** — only if you want Google Maps support

### 📋 **Prerequisites**
- ☕ **Java 8 JDK** (JDK 17+ will *not* work — the Scala plugin requires JDK 8)
- 🐙 **Git** for version control
- 📦 **Android SDK** with `platforms;android-33` and `build-tools;33.0.2`
- 🗺️ **Google Maps API Key** — *Optional*, only for Google Maps support

### 📱 **Android SDK levels**
| | API | Notes |
| --- | --- | --- |
| `minSdkVersion` | 14 | Android 4.0 (Ice Cream Sandwich) |
| `compileSdkVersion` | 33 | Held at 33 — see note below |
| `targetSdkVersion` | 35 | Android 15 — satisfies Google Play targetSdk floor |

> **Why `compileSdk` is 33 while `targetSdk` is 35:** the
> `gradle-android-scala-plugin` (AllBus fork, 3.5.1) only supports AGP 3.5.x, and no
> maintained Scala plugin supports AGP 8.x+ as of 2026. AGP 3.5.x cannot compile
> against API 36. `targetSdk 35` is still achievable and satisfies the Google Play
> requirement; the app runs on Android 14/15 via platform compatibility behaviors.

### 🗝️ **Important Notice: Google Maps**
> ⚠️ **The mod focuses on offline mapping** (MBTiles + MapsForge) for privacy and reduced
> dependencies. The Google Maps dependency is still present but uses a fallback restricted
> key at runtime. To enable Google Maps, build from source and add your own API key to
> `local.properties`.

### 🚀 **Complete Build Instructions**

```bash
sudo apt-get install -y git openjdk-8-jdk vim-nox wget unzip

cmdline_tool_file="commandlinetools-linux-6609375_latest.zip"
export ANDROID_SDK_ROOT="$(pwd)/android"
mkdir -p "${ANDROID_SDK_ROOT}"
wget "https://dl.google.com/android/repository/${cmdline_tool_file}"
unzip "${cmdline_tool_file}" -d "${ANDROID_SDK_ROOT}/cmdline-tools"
rm -f "${cmdline_tool_file}"
export PATH="${ANDROID_SDK_ROOT}/cmdline-tools/tools/bin:${PATH}"
export PATH="${ANDROID_SDK_ROOT}/platform-tools:${PATH}"
export PATH="${ANDROID_SDK_ROOT}/emulator:${PATH}"
mkdir "${ANDROID_SDK_ROOT}/licenses"
echo 24333f8a63b6825ea9c5514f83c2829b004d1fee > "${ANDROID_SDK_ROOT}/licenses/android-sdk-license"
echo 84831b9409646a918e30573bab4c9c91346d8abd > "${ANDROID_SDK_ROOT}/licenses/android-sdk-preview-license"
sdkmanager --install 'platforms;android-33' 'build-tools;33.0.2'

git clone https://github.com/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod.git
cd NA7Q-APRSDroid-9M2PJU-Mod
git submodule update --init --recursive
# optional: replace AI... with your Google Maps API key:
echo "mapsApiKey=AI..." > local.properties
# for a release build (unsigned without signing properties):
./gradlew assembleRelease
# to sign, pass -PRELEASE_STORE_FILE=... -PRELEASE_KEY_ALIAS=... etc.
```

---

## 🌐 **Landing Page & Download Counters**

A static landing page is published via GitHub Pages at
**<https://aprsdroid.hamradio.my/>**. It shows:

- App branding (icon, splash, features)
- **Download buttons** for the latest release APK
- **Live download counters** — per-release and total — fetched client-side from the
  public GitHub API (`download_count` per release asset). No backend, no separate
  counter service; the numbers are real GitHub release download counts.

Source for the page lives in the [`docs/`](docs/) folder. Edit `docs/index.html`,
`docs/style.css`, or `docs/script.js` and push to `master` — GitHub Pages rebuilds
automatically.

---

## 📜 **License**

This project is licensed under the **GNU General Public License v2.0** — see the
[LICENSE](LICENSE) file for details.

---

## 🤝 **Contributing**

Contributions are welcome from the amateur radio community! Whether you're fixing bugs,
adding features, or improving documentation, your help makes APRSdroid better for everyone.
Please open an issue or pull request at the
[**9M2PJU-Mod repo**](https://github.com/9M2PJU/NA7Q-APRSDroid-9M2PJU-Mod).

---

## 🙏 **Credits**

- **Georg Lukas (ge0rg)** — original [APRSdroid](https://aprsdroid.org/)
- **NA7Q** — [enhanced APRSdroid fork](https://github.com/na7q/aprsdroid) that this mod builds on
- **9M2PJU** — this mod's splash, icon, CI/CD, modern Android support, and landing page
- **Bob Bruninga, WB4APR** — creator of APRS

APRS® is a registered trademark of Bob Bruninga, WB4APR.

---

<div align="center">

**Made with ❤️ by Amateur Radio operators, for Amateur Radio operators**

*73 and happy APRSing!* 📡

</div>
