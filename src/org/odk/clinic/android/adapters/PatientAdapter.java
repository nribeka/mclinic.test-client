package org.odk.clinic.android.adapters;

import java.util.List;

import org.odk.clinic.android.R;
import org.odk.clinic.android.openmrs.Patient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PatientAdapter extends ArrayAdapter<Patient> {

	public PatientAdapter(Context context, int textViewResourceId,
			List<Patient> items) {
		super(context, textViewResourceId, items);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.patient_list_item, null);
		}
		Patient p = getItem(position);
		if (p != null) {

			TextView textView = (TextView) v.findViewById(R.id.identifier_text);
			if (textView != null) {
				textView.setText(p.getIdentifier());
			}

			textView = (TextView) v.findViewById(R.id.name_text);
			if (textView != null) {
				textView.setText(p.getName());
			}

			textView = (TextView) v.findViewById(R.id.birthdate_text);
			if (textView != null) {
				textView.setText(p.getBirthdate());
			}

			ImageView imageView = (ImageView) v.findViewById(R.id.gender_image);
			if (imageView != null) {
				if (p.getGender().equals("M")) {
					imageView.setImageResource(R.drawable.male);
				} else if (p.getGender().equals("F")) {
					imageView.setImageResource(R.drawable.female);
				}
			}
		}
		return v;
	}
}
