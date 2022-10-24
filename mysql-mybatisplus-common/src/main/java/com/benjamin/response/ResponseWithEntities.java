package com.benjamin.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseWithEntities<T> extends BaseResponse {
    private T data;

    public T getData() {
        return this.data;
    }

    public ResponseWithEntities<T> setData(final T data) {
        this.data = data;
        return this;
    }

    public String toString() {
        return "ResponseWithEntities(data=" + this.getData() + ")";
    }

    public ResponseWithEntities() {
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseWithEntities)) {
            return false;
        } else {
            ResponseWithEntities<?> other = (ResponseWithEntities)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResponseWithEntities;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = super.hashCode();
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }
}
