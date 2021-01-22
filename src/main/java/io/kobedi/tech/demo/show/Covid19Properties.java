package io.kobedi.tech.demo.show;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "covid19")
@Component
public class Covid19Properties {
	
	private Long gatheringLimit;
	private String gatheringLimitEffectiveDate;
	private String gatheringLimitReviewDate;
	private String curfewDuration;
	private boolean maskMandatory;
	private boolean notWearingMaskWarrantsCriminalRecord;
	
	
	public Long getGatheringLimit() {
		return gatheringLimit;
	}
	public void setGatheringLimit(Long gatheringLimit) {
		this.gatheringLimit = gatheringLimit;
	}
	public String getGatheringLimitEffectiveDate() {
		return gatheringLimitEffectiveDate;
	}
	public void setGatheringLimitEffectiveDate(String gatheringLimitEffectiveDate) {
		this.gatheringLimitEffectiveDate = gatheringLimitEffectiveDate;
	}
	public String getGatheringLimitReviewDate() {
		return gatheringLimitReviewDate;
	}
	public void setGatheringLimitReviewDate(String gatheringLimitReviewDate) {
		this.gatheringLimitReviewDate = gatheringLimitReviewDate;
	}
	public String getCurfewDuration() {
		return curfewDuration;
	}
	public void setCurfewDuration(String curfewDuration) {
		this.curfewDuration = curfewDuration;
	}
	
	public boolean isNotWearingMaskWarrantsCriminalRecord() {
		return notWearingMaskWarrantsCriminalRecord;
	}
	public void setNotWearingMaskWarrantsCriminalRecord(boolean notWearingMaskWarrantsCriminalRecord) {
		this.notWearingMaskWarrantsCriminalRecord = notWearingMaskWarrantsCriminalRecord;
	}
	public boolean isMaskMandatory() {
		return maskMandatory;
	}
	public void setMaskMandatory(boolean maskMandatory) {
		this.maskMandatory = maskMandatory;
	}
	
	
	//Perfect Example - Single Responsibility
	@Override
	public String toString() {
		return "Covid19Properties [gatheringLimit=" + gatheringLimit + ", gatheringLimitEffectiveDate="
				+ gatheringLimitEffectiveDate + ", gatheringLimitReviewDate=" + gatheringLimitReviewDate
				+ ", curfewDuration=" + curfewDuration + ", maskMandatory=" + maskMandatory
				+ ", notWearingMaskWarrantsCriminalRecord=" + notWearingMaskWarrantsCriminalRecord + "]";
	}
		
	
}
