package org.odk.clinic.android.openmrs;

import org.odk.clinic.android.utilities.Constants;


public class Observation {

	private Integer patientId = null;
	private Double valueNumeric;
	private Integer valueInt;
	private String valueDate;
	private String valueText;
	private String encounterDate;
	private String fieldName;
	private byte dataType;

	public String toString() {
		switch (dataType) {
			case Constants.TYPE_INT :
				return valueInt.toString();
			case Constants.TYPE_DOUBLE:
				return valueNumeric.toString();
			case Constants.TYPE_DATE :
				return valueDate.toString();
			default :
				return valueText;
		}
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Double getValueNumeric() {
		return valueNumeric;
	}

	public void setValueNumeric(Double valueNumeric) {
		this.valueNumeric = valueNumeric;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getValueText() {
		return valueText;
	}

	public void setValueText(String valueText) {
		this.valueText = valueText;
	}

	public String getEncounterDate() {
		return encounterDate;
	}

	public void setEncounterDate(String encounterDate) {
		this.encounterDate = encounterDate;
	}

	public Integer getValueInt() {
		return valueInt;
	}

	public void setValueInt(Integer valueInt) {
		this.valueInt = valueInt;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public byte getDataType() {
		return dataType;
	}

	public void setDataType(byte dataType) {
		this.dataType = dataType;
	}
}
