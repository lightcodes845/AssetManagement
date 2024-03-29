package com.sprintell.assetmanagement.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AssetHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assetHistoryId;

    private LocalDateTime timestamp;
    private String description;
    private String notes;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="assetId")
    private Asset asset;

    public AssetHistory() {
    }

    public Long getAssetHistoryId() {
        return assetHistoryId;
    }

    public void setAssetHistoryId(Long assetHistoryId) {
        this.assetHistoryId = assetHistoryId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
