package com.Safetynet.Utils;

import com.Safetynet.Model.Data;

import java.io.File;
import java.io.IOException;

public interface IDataloader {
    void setDataFile(Data data);
    void loadData();
    void daoConstruct();
}
