package io.quell.entities;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
//@NamedQuery(name = "readMaster", query = "SELECT e from OptionsMaster e")
@Table(name = "OPTIONS_MASTER")
public class OptionsMaster {

    @Id
    @SequenceGenerator(name = "m_seq", sequenceName = "m_seq", allocationSize = 1)
    @GeneratedValue(generator = "m_seq")
    @Column(name = "MID")
    Long mId;

    @Column(name = "MESSAGE")
    String message;

    @Column(name = "DESTINATION")
    String destination;

    @Column(name = "MESSAGE_TYPE")
    String messageType;

    @Column(name = "CREATED_DATE")
    Timestamp createdDate;

    @Column(name = "UPDATED_DATE")
    Timestamp updatedDate;
}
