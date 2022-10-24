package com.benjamin.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseResponse {
    private Long code = 0L;
    private Long status = 0L;
    private String message = "success";
    private String view = "success";
    private Long timestamp = System.currentTimeMillis();

    public BaseResponse() {
    }

    public Long getCode() {
        return this.code;
    }

    public Long getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getView() {
        return this.view;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public BaseResponse setCode(final Long code) {
        this.code = code;
        return this;
    }

    public BaseResponse setStatus(final Long status) {
        this.status = status;
        return this;
    }

    public BaseResponse setMessage(final String message) {
        this.message = message;
        return this;
    }

    public BaseResponse setView(final String view) {
        this.view = view;
        return this;
    }

    public BaseResponse setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseResponse)) {
            return false;
        } else {
            BaseResponse other = (BaseResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label71;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label71;
                    }

                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                label57: {
                    Object this$timestamp = this.getTimestamp();
                    Object other$timestamp = other.getTimestamp();
                    if (this$timestamp == null) {
                        if (other$timestamp == null) {
                            break label57;
                        }
                    } else if (this$timestamp.equals(other$timestamp)) {
                        break label57;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$view = this.getView();
                Object other$view = other.getView();
                if (this$view == null) {
                    if (other$view == null) {
                        return true;
                    }
                } else if (this$view.equals(other$view)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BaseResponse;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $timestamp = this.getTimestamp();
        result = result * 59 + ($timestamp == null ? 43 : $timestamp.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $view = this.getView();
        result = result * 59 + ($view == null ? 43 : $view.hashCode());
        return result;
    }

    public String toString() {
        return "BaseResponse(code=" + this.getCode() + ", status=" + this.getStatus() + ", message=" + this.getMessage() + ", view=" + this.getView() + ", timestamp=" + this.getTimestamp() + ")";
    }
}
