package hellojpa;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="new_table")
public class TestMember {

    private LocalDate localDate;
    private LocalDateTime localDateTime;

    @Lob
    private String bigData;

    @Enumerated(EnumType.STRING)
    private TestRecord testRecord;

    @Transient
    private String temp;

    @Id
    private long realId;

    public TestMember() {
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getBigData() {
        return bigData;
    }

    public void setBigData(String bigData) {
        this.bigData = bigData;
    }

    public TestRecord getTestRecord() {
        return testRecord;
    }

    public void setTestRecord(TestRecord testRecord) {
        this.testRecord = testRecord;
    }
}
