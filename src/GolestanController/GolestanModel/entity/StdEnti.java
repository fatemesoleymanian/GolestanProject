package GolestanModel.entity;

public class StdEnti {
    String stdNum;
    String stdName;
    String gender;
    String fatherName;
    String nationalId;
    String birthDate;
    String entryTerm;
    String average;
    String unitCode;

    public String getUnitCode() {
        return unitCode;
    }

    public StdEnti setUnitCode(String unitCode) {
        this.unitCode = unitCode;
        return this;
    }

    public String getAverage() {
        return average;
    }

    public StdEnti setAverage(String average) {
        this.average = average;
        return this;
    }

    public String getPassedUnits() {
        return passedUnits;
    }

    public StdEnti setPassedUnits(String passedUnits) {
        this.passedUnits = passedUnits;
        return this;
    }

    String passedUnits;
    String deleteReason,year;
    String username,password;
    String paymentAmount,cardNumber,cardSecondPass,cvv2,expireDay,expireYear;

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public StdEnti setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public StdEnti setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getCardSecondPass() {
        return cardSecondPass;
    }

    public StdEnti setCardSecondPass(String cardSecondPass) {
        this.cardSecondPass = cardSecondPass;
        return this;
    }

    public String getCvv2() {
        return cvv2;
    }

    public StdEnti setCvv2(String cvv2) {
        this.cvv2 = cvv2;
        return this;
    }

    public String getExpireDay() {
        return expireDay;
    }

    public StdEnti setExpireDay(String expireDay) {
        this.expireDay = expireDay;
        return this;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public StdEnti setExpireYear(String expireYear) {
        this.expireYear = expireYear;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public StdEnti setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public StdEnti setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getStdID() {
        return stdID;
    }

    public StdEnti setStdID(String stdID) {
        this.stdID = stdID;
        return this;
    }

    String stdID;

    public String getDeleteReason() {
        return deleteReason;
    }

    public StdEnti setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
        return this;
    }

    public String getYear() {
        return year;
    }

    public StdEnti setYear(String year) {
        this.year = year;
        return this;
    }

    public String getStdNum() {
        return stdNum;
    }

    public StdEnti setStdNum(String stdNum) {
        this.stdNum = stdNum;
        return this;
    }

    public String getStdName() {
        return stdName;
    }

    public StdEnti setStdName(String stdName) {
        this.stdName = stdName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public StdEnti setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public StdEnti setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getNationalId() {
        return nationalId;
    }

    public StdEnti setNationalId(String nationalId) {
        this.nationalId = nationalId;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public StdEnti setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getEntryTerm() {
        return entryTerm;
    }

    public StdEnti setEntryTerm(String entryTerm) {
        this.entryTerm = entryTerm;
        return this;
    }
}
