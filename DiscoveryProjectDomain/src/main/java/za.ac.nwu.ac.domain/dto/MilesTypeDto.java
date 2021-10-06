package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.MilesType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MilesTypeDto  implements Serializable {
    private static final long serialVersionUID = 595554;

    private String mnemonic;
    private String accountName;
    private LocalDate creationDate;



    public MilesTypeDto(String mnemonic, String accountName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountName = accountName;
        this.creationDate = creationDate;
    }

    public MilesTypeDto( milesType)
    {MilesType
        this.setAccountName(milesType.getAccountName());
        this.setCreationDate(milesType.getCreationDate());
        this.setMnemonic(milesType.getMnemonic());
    }

    @ApiModelProperty(position = 1,
    value = "Miles Type Mnemonic",
    name = "Mnemonic",
    notes = "Uniquely identifies miles type",
    dataType = "java.lang.String",
    example = "MILES",
    required = true)

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
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
        MilesTypeDto that = (MilesTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountName, that.accountName) && Objects.equals(creationDate, that.creationDate);
    }

    @JsonIgnore
    public MilesType getMilesType()
    {
        return new MilesType(getMnemonic(), getAccountName(), getCreationDate());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mnemonic, accountName, creationDate);
    }

    @Override
    public String toString()
    {
        return "MilesTypeDto{"+" +
            "mnemonic" + mnemonic + "'\'" +
            ", accountTypeName" + accountName + "'\'" +
             ", creationDate " + creationDate +
             '}";
    }

}
