package com.assignment.question1.fileconfigurationmanager;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager{

    private static FileBasedConfigurationManagerImpl instance;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private FileBasedConfigurationManagerImpl(){
        super();
    }
    @Override
    public String getConfiguration(String key) {
        // TODO Auto-generated method stub
        return instance.properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
      String value=instance.properties.getProperty(key);
      if(value!=null){
          return instance.convert(value,type);
      }
      return null;
    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        instance.properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        instance.properties.setProperty(key,value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        // TODO Auto-generated method stub
       instance.properties.remove(key);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        instance.properties.clear();
    }

    public static FileBasedConfigurationManagerImpl getInstance() {
        // TODO Auto-generated method stub
        if(instance==null){
            synchronized (FileBasedConfigurationManagerImpl.class){
                if(instance==null)
                 instance=new FileBasedConfigurationManagerImpl();
            }
        }
        return instance;
    }

    public static void resetInstance() {
        // TODO Auto-generated method stub
        instance.clear();
    }
}
