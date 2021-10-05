package za.ac.nwu.ac.domain.service;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse <T> implements Serializable {

    private static final long serialVersionUID = 2109552;
    private final boolean successfull;
    private final transient T payload;

    public GeneralResponse(boolean successfull, T payload)
    {
        this.successfull = successfull;
        this.payload = payload;
    }

    public boolean isSuccessfull() {
        return successfull;
    }

    public T getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) o;
        return successfull == that.successfull && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(successfull, payload);
    }

    @Override
    public java.lang.String toString()
    {
        return "GeneralResponse{" +
        "successfull=" + successfull +
        ", payload=" + payload +
        "}";
    }
}
