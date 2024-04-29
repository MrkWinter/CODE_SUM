package com.work04.project2;

/**
 * @author MrkWinter
 * @version 1.0
 */


import java.util.ArrayList;
import java.util.List;

public class MajorInfo {
    private String name;
    private List<Class> classList;

    public MajorInfo(String name) {
        this.name = name;
        this.classList = new ArrayList<>();
    }

    public void addClass(Class classObj) {
        classList.add(classObj);
    }

    public int getStudentCount() {
        int count = 0;
        for (Class classObj : classList) {
            count += classObj.getStudentCount();
        }
        return count;
    }

    public Class getClassByClassId(int classId) {
        for (Class classObj : classList) {
            if (classObj.getClassId() == classId) {
                return classObj;
            }
        }
        return null;
    }

    public List<Class> getClassList() {
        return new ArrayList<>();
    }

    // 其他需要的方法

    // Getter and Setter
}
