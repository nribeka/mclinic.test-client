package org.odk.clinic.android.tasks;

import java.io.DataInputStream;

import org.odk.clinic.android.openmrs.Cohort;

public class DownloadCohortTask extends DownloadTask {

	public static final String KEY_ERROR = "error";
	public static final String KEY_COHORTS = "cohorts";

	@Override
	protected String doInBackground(String... values) {

		String url = values[0];
		String username = values[1];
		String password = values[2];
		boolean savedSearch = Boolean.valueOf(values[3]);

		try {
			DataInputStream zdis = connectToServer(url, username, password, savedSearch, -1, -1);
			if (zdis != null) {
				// open db and clean entries
				mPatientDbAdapter.open();
				mPatientDbAdapter.deleteAllCohorts();
				
				// download and insert patients and obs
				insertCohorts(zdis);
				
				// close db and stream
				mPatientDbAdapter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
            if (mPatientDbAdapter != null) {
            	mPatientDbAdapter.close();
            }
			return e.getLocalizedMessage();
		}

		return null;
	}

	private void insertCohorts(DataInputStream zdis)
			throws Exception {

		int count = zdis.readInt();
		
		for (int i = 1; i < count + 1; i++) {
			Cohort c = new Cohort();
			c.setCohortId(zdis.readInt());
			c.setName(zdis.readUTF());

			mPatientDbAdapter.createCohort(c);

			publishProgress("cohorts", Integer.valueOf(i).toString(), Integer
					.valueOf(count).toString());
		}

	}

}

