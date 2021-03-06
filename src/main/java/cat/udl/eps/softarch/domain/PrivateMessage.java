package cat.udl.eps.softarch.domain;

/**
 * Created by jap9 on 22/09/16. Updated 23/10/16 added "sender" field
 */
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="uri")
public class PrivateMessage extends UriEntity{

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Body cannot be blank")
    private String body;

    @NotBlank(message = "Destination cannot be blank")
    private String destination;

    @NotBlank(message = "Sender cannot be blank")
    private String sender;

    private boolean isRead;

    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public String getDestination() {
        return destination;
    }
    public String getSender() {
        return sender;
    }
    public boolean getIsRead() {
        return isRead;
    }
}

