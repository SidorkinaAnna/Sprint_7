package courier.pojo;

import java.util.Objects;

public class ResponseSuccess {
    private String ok;

    public ResponseSuccess(String ok) {
        this.ok = ok;
    }

    public ResponseSuccess() {
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "{" +
                "ok='" + ok + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ResponseSuccess that = (ResponseSuccess) o;
        return Objects.equals(ok, that.ok);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ok);
    }
}
