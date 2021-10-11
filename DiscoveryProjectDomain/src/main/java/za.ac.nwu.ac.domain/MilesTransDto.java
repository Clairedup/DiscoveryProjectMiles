package za.ac.nwu.ac.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.dto.MilesTypeDto;
import za.ac.nwu.ac.domain.persistence.MilesTrans;
import za.ac.nwu.ac.domain.persistence.MilesType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MilesTransDto implements Serializable {

    private static final long serialVersionUID = 595554;

    private String Trans_ID;
    private String amount;
    private String memberID;
    private LocalDate transDate;



    public MilesTypeDto(String amount, String memberID, LocalDate transDate) {
        this.amount = amount;
        this.memberID = memberID;
        this.transDate = transDate;
    }

    public MilesTransDto( milesTrans)
    {
        MilesTrans
        this.setAccountName(MilesTrans.getMemberID());
        this.setCreationDate(MilesTrans.getTransDate());
        this.setMnemonic(MilesTrans.getAmount());
    }

    @ApiModelProperty(position = 1,
            value = "Miles Trans amount",
            name = "amount",
            notes = "How many miles user has",
            dataType = "java.lang.String",
            example = "200",
            required = false)

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 2,
            value = "MilesType name",
            name = "Name",
            notes = "Name of miles type",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @ApiModelProperty(position = 3,
            value = "MilesType Creation date",
            name = "CreationDate",
            notes = "Date account was created",
            dataType = "java.lang.String",
            example = "2021-09-29",
            allowEmptyValue = true,
            required = false)

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null || getClass() != o.getClass()) return false;
        MilesTransDto that = (MilesTransDto) o;
        return Objects.equals(amount, that.amount) && Objects.equals(amount, that.amount) && Objects.equals(transDate, that.transDate);
    }

    @JsonIgnore
    public MilesTrans getMilesTrans()
    {
        return new MilesTrans(getAmount(), getAccountName(), getTransDate());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(amount, memberID, transDate);
    }

    @Override
    public String toString()
    {
        return "MilesTransDto{"+" +
        "MemberID" + memberID + "'\'" +
                ", amount" + amount + "'\'" +
                ", transDate " + transDate +
                '}";
    }
}
