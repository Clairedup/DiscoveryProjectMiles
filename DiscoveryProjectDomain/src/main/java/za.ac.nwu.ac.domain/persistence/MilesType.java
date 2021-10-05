package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MILES_TYPE", schema = "VITRSA_SANDBOX")
public class MilesType implements Serializable
{
    private static final long serialVersionUID = 3_816_165_46;

    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")

    @Column(name = "TYPE_ID")
    private long typeId;

    @Column(name = "MNEMONIC")
    private String mnemonic;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    public MilesType(long typeId, String mnemonic, String accountName, LocalDate creationDate) {
        this.typeId = typeId;
        this.mnemonic = mnemonic;
        this.accountName = accountName;
        this.creationDate = creationDate;
    }

    @OneToMany(targetEntity = MilesTrans.class, fetch = FetchType.LAZY, mappedBy = "milesType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<MilesTrans> getMilesTrans()
    {
        return milesType;
    }

    public void setMilesTrans(Set<MilesTrans> milesTrans)
    {
        this.milesTrans = milesTrans;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilesType milesType = (MilesType) o;
        return typeId == milesType.typeId && Objects.equals(mnemonic, milesType.mnemonic) && Objects.equals(accountName, milesType.accountName) && Objects.equals(creationDate, milesType.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, mnemonic, accountName, creationDate);
    }
}

