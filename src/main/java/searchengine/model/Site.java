package searchengine.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "site_status", nullable = false)
    private SiteStatus status;

    @Column(name = "status_time",nullable = false)
    private Date statusTime;

    @Column(name = "last_error",nullable = false, columnDefinition = "TEXT")
    private String lastError;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String  url;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String name;

    @OneToMany(mappedBy = "siteId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Page> pageList = new ArrayList<>();
}
