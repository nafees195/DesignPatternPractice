package com.assignment.question1.fileconfigurationmanager;

import java.util.concurrent.Callable;

public class InstanceProvider implements Callable<FileBasedConfigurationManagerImpl> {
    @Override
    public FileBasedConfigurationManagerImpl call() throws Exception {
        return FileBasedConfigurationManagerImpl.getInstance();
    }
}
