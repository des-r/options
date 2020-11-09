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
@Table(name = "OPTIONS_TRAN")
public class OptionsTran {

    @Id
    @SequenceGenerator(name = "t_seq", sequenceName = "t_seq", allocationSize = 1)
    @GeneratedValue(generator = "t_seq")
    @Column(name = "TID")
    Long tId;

    @OneToOne
    @JoinColumn(name = "MID")
    OptionsMaster optionsMaster;

    @Column(name = "MESSAGE")
    String message;

    @Column(name = "CREATED_DATE")
    Timestamp createdDate;

    @Column(name = "UPDATED_DATE")
    Timestamp updatedDate;
}
