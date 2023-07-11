package dev.chrono.chronochallenge.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "correct_person")
    private Member member;

    @Column
    private int answer;

    @Column(name="multiple_candidate1")
    private String multipleCandidate1;

    @Column(name="multiple_candidate2")
    private String multipleCandidate2;

    @Column(name="multiple_candidate3")
    private String multipleCandidate3;

    @Column(name="multiple_candidate4")
    private String multipleCandidate4;

    @Column
    private int point;

    @Column
    private boolean status;

    @Column(name="createdAt")
    private Date created_at;

    @Column(name="modifiedAt")
    private Date modified_at;

    @Builder
    public Quiz(Long id, Member member, int answer, String multipleCandidate1, String multipleCandidate2, String multipleCandidate3, String multipleCandidate4, int point, boolean status, Date created_at, Date modified_at) {
        this.id = id;
        this.member = member;
        this.answer = answer;
        this.multipleCandidate1 = multipleCandidate1;
        this.multipleCandidate2 = multipleCandidate2;
        this.multipleCandidate3 = multipleCandidate3;
        this.multipleCandidate4 = multipleCandidate4;
        this.point = point;
        this.status = status;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }
}
