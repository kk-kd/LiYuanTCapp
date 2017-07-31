package db;

/**
 * Created by Administrator on 2017/7/30.
 */

public class file  {
    private int id;
    private String filename;
    private String editor;

   public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getfilename(){
        return filename;
    }
    public void setFilename(String filename){
        this.filename=filename;
    }

    public String getEditor(){
        return editor;
    }
    public void setEditor(String editor){
        this.editor = editor;
    }

}
