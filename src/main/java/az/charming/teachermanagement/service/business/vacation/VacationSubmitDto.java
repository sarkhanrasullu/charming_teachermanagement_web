package az.charming.teachermanagement.service.business.vacation;

public class VacationSubmitDto {

    private String submitter;
    private String reason;

    public String getSubmitter() {
        return submitter;
    }

    public VacationSubmitDto setSubmitter(String submitter) {
        this.submitter = submitter;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public VacationSubmitDto setReason(String reason) {
        this.reason = reason;
        return this;
    }
}
