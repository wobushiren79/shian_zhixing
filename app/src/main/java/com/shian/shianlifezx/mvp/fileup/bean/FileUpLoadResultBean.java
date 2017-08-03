package com.shian.shianlifezx.mvp.fileup.bean;

import java.util.Map;

/**
 * Created by zm.
 */

public class FileUpLoadResultBean {
    /**
     * "nameMap":{
     "filename1":"fileUrl1",
     "fileName2":"fileUrl2"
     }
     */
    private Map nameMap;

    public Map getNameMap() {
        return nameMap;
    }

    public void setNameMap(Map nameMap) {
        this.nameMap = nameMap;
    }

    public class NameMap{
        private String file;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }
    }
}
