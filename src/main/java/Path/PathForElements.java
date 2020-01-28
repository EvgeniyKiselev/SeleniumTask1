package Path;

public class PathForElements {

    String surnameOfInsured;
    String nameOfInsured;
    String dateOfBirthOfInsured;
    String lastNameOfPayer;
    String nameOfPayer;
    String fatherNameOfPayer;
    String dateOfBirthOfPayer;
    String docSeries;
    String docNumber;
    String docDate;
    String docIssue;

    public String getSurnameOfInsured() {
        return surnameOfInsured;
    }

    public String getNameOfInsured() {
        return nameOfInsured;
    }

    public String getDateOfBirthOfInsured() {
        return dateOfBirthOfInsured;
    }

    public String getLastNameOfPayer() {
        return lastNameOfPayer;
    }

    public String getNameOfPayer() {
        return nameOfPayer;
    }

    public String getFatherNameOfPayer() {
        return fatherNameOfPayer;
    }

    public String getDateOfBirthOfPayer() {
        return dateOfBirthOfPayer;
    }

    public String getDocSeries() {
        return docSeries;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public String getDocIssue() {
        return docIssue;
    }

    public PathForElements(String surnameOfInsured, String nameOfInsured, String dateOfBirthOfInsured, String lastNameOfPayer, String nameOfPayer, String fatherNameOfPayer, String dateOfBirthOfPayer, String docSeries, String docNumber, String docDate, String docIssue) {
        this.surnameOfInsured = surnameOfInsured;
        this.nameOfInsured = nameOfInsured;
        this.dateOfBirthOfInsured = dateOfBirthOfInsured;
        this.lastNameOfPayer = lastNameOfPayer;
        this.nameOfPayer = nameOfPayer;
        this.fatherNameOfPayer = fatherNameOfPayer;
        this.dateOfBirthOfPayer = dateOfBirthOfPayer;
        this.docSeries = docSeries;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.docIssue = docIssue;
    }
}
