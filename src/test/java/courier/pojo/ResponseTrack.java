package courier.pojo;

import java.util.Objects;

public class ResponseTrack {
    private String track;

    public ResponseTrack(String track) {
        this.track = track;
    }

    public ResponseTrack() {
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    @Override
    public String toString() {
        return "{" +
                "track='" + track + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ResponseTrack that = (ResponseTrack) o;
        return Objects.equals(track, that.track);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(track);
    }
}
