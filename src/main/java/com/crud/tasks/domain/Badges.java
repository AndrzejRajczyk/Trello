package com.crud.tasks.domain;

import lombok.Data;

@Data
public class Badges {
    int votes;
    AttachmentsByType attachmentsByType;
}
