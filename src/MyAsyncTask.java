package org.aprsdroid.app;

import android.os.AsyncTask;

/**
 * Temporary workaround to solve a Scala compiler issue which shows up
 * at runtime with the error message
 * "java.lang.AbstractMethodError: abstract method not implemented"
 * for the missing method LookupTask.doInBackground(String... args).
 *
 * Our solution: the Java method doInBackground(String... args) forwards
 * the call to the Scala method doInBackground1(String[] args).
 */
public abstract class MyAsyncTask<Progress, Result> extends AsyncTask<String, Progress, Result> {

    protected abstract Result doInBackground1(String[] args);

    /**
     * Optional override for progress updates — Scala can't override
     * onProgressUpdate(Progress... values) directly due to varargs,
     * so we bridge through onProgressUpdate1(Progress[] values).
     */
    protected void onProgressUpdate1(Progress[] values) {
        // default: no-op
    }

    @Override
    protected Result doInBackground(String... args) {
        String[] args1 = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            args1[i] = args[i];
        }
        return doInBackground1(args1);
    }

    @Override
    protected void onProgressUpdate(Progress... values) {
        @SuppressWarnings("unchecked")
        Progress[] values1 = (Progress[]) new Object[values.length];
        for (int i = 0; i < values.length; i++) {
            values1[i] = values[i];
        }
        onProgressUpdate1(values1);
    }

}

