package com.yht.image.model.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * //TODO
 *
 * @author Lionel
 * @version 1.0.0
 * @email liuqiang@1haitao.com
 * @date 2019-07-10
 * Modification  History:
 * Date         Author        Version        Description
 * ------------------------------------------------------
 * 2019-07-10   Lionel     1.0.0          create
 */
public class ImageUploadDto implements Serializable {

    private static final long serialVersionUID = -6158169815174224331L;

    private String relativePath;

    private String name;

    private String type;

    private List<MultipartFile> files;

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
