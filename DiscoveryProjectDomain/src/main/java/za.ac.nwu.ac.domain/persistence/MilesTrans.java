package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MILES_TRANS", schema = "VITRSA_SANDBOX")
public class MilesTrans implements Serializable {

    private static final long serialVersionUID = 3_816_165_46;

    private Long transactionID;
    private MilesType milesType;
    private  Long memberID;
    private Long account;
    private LocalDate transactionDate;

    private MilesTransDetails details;


    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE.AUTO, generator = "VIT_RSA_GENERIC_SEQ")

    @Column(name = "TRANS_ID")
    private long transId;

    @Column(name = "TYPE_ID")
    private long typeId;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "MEMBER_ID")
    private long MemberId;

    @Column(name = "TRANS_DATE")
    private LocalDate TransDate;

    public MilesTrans(long typeId, long typeId1, long amount, long memberId, LocalDate transDate) {
        this.typeId = typeId;
        this.typeId = typeId1;
        this.amount = amount;
        MemberId = memberId;
        TransDate = transDate;
    }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "TYPE_ID")
   public MilesType getMilesType()
   {
       return getMilesType();
   }


    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getMemberId() {
        return MemberId;
    }

    public void setMemberId(long memberId) {
        MemberId = memberId;
    }

    public LocalDate getTransDate() {
        return TransDate;
    }

    public void setTransDate(LocalDate transDate) {
        TransDate = transDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MilesTrans that = (MilesTrans) o;
        return typeId == that.typeId && typeId == that.typeId && amount == that.amount && MemberId == that.MemberId && Objects.equals(TransDate, that.TransDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeId, amount, MemberId, TransDate);
    }
}
