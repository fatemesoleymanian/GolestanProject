package GolestanModel.entity;

public class TeacherEnti {
    String stdName,stdNum,subjectCode,score;
    String deleteTime,DeleteReason;

    public String getDeleteTime() {
        return deleteTime;
    }

    public TeacherEnti setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
        return this;
    }

    public String getDeleteReason() {
        return DeleteReason;
    }

    public TeacherEnti setDeleteReason(String deleteReason) {
        DeleteReason = deleteReason;
        return this;
    }

    public String getStdName() {
        return stdName;
    }

    public TeacherEnti setStdName(String stdName) {
        this.stdName = stdName;
        return this;
    }

    public String getStdNum() {
        return stdNum;
    }

    public TeacherEnti setStdNum(String stdNum) {
        this.stdNum = stdNum;
        return this;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public TeacherEnti setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
        return this;
    }

    public String getScore() {
        return score;
    }

    public TeacherEnti setScore(String score) {
        this.score = score;
        return this;
    }
}
