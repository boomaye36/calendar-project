package com.example.calendarapi.dto;

import com.example.calendarcore.domain.RequestReplyType;
import lombok.NoArgsConstructor;

public class ReplyEngagementReq {
    private  RequestReplyType type;
    public ReplyEngagementReq(){}

    public ReplyEngagementReq(RequestReplyType type) {
        this.type = type;
    }

    public RequestReplyType getType() {
        return type;
    }
}
