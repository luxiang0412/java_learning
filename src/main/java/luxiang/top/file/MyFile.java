package luxiang.top.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class MyFile {
    public static void main(String[] args) throws URISyntaxException, IOException {

        File dir = new File("/home/luxiang");

        System.out.println("dir is dir:" + dir.isDirectory());//true

        //构造方法一
        File childFile = new File(dir, "test");

        System.out.println("childFile is file:" + childFile.isFile());//true

        //构造方法二
        File text = new File("/home/luxiang/test");

        //构造方法三
        File childFile2 = new File("/home/luxiang", "test");

        System.out.println("childFile2 is file:" + childFile2.isFile());//true

        URI uri = new URI("file:///home/luxiang/%E4%B8%8B%E8%BD%BD/docs/api/java/net/URI.html");

        //构造方法四
        File urlFile = new File(uri);

        System.out.println("urlFile is file:" + urlFile.isFile());

        //与系统相关的路径分隔符 类型 char
        System.out.println(File.separatorChar);
        //与系统相关的路径分隔符 类型 String
        System.out.println(File.separator);
        //系统相关的默认名称分隔符，为方便起见，表示为字符串 类型 char
        //例如linux系统的path    /usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games
        //以:来分隔 而window系统则以;分隔
        System.out.println(File.pathSeparatorChar);
        //系统相关的默认名称分隔符。 类型 String
        //同上
        System.out.println(File.pathSeparator);
        //文件（linux下所有都是文件）是否有可执行权限（当前用户）
        System.out.println("text is can exe:" + text.canExecute());
        //文件（linux下所有都是文件）是否有可读权限（当前用户）
        System.out.println(text.canRead());
        //文件（linux下所有都是文件）是否有可写权限（当前用户）
        System.out.println(text.canWrite());
        //var1.getPath().compareTo(var2.getPath()) 根据不同的操作系统获取文件系统  然后比较路径  调用string中的compareTo
        System.out.println(dir.compareTo(text));
        //文件不存在时创建文件
        System.out.println(text.createNewFile());
        //创建一个临时文件
        File tmp;
        System.out.println((tmp = File.createTempFile("test", "sh", dir)));// /home/luxiang/test883462112266860616sh
        if (tmp.exists()) System.out.println(tmp.delete());

        System.out.println("text equals childFile:" + text.equals(childFile));

        File abPath = new File(System.getProperty("user.dir"));
        //返回一个string
        //  if (isAbsolute(f)) return f.getPath();
        //        return resolve(System.getProperty("user.dir"), f.getPath());
        System.out.println("getAbsolutePath:" + abPath.getAbsolutePath());
        //返回一个file
        System.out.println("getAbsoluteFile:" + abPath.getAbsoluteFile());

        System.out.println("" + abPath.getCanonicalPath());

        System.out.println("" + abPath.getCanonicalFile());

        System.out.println("text parent :" + text.getParent());

        System.out.println("text childFIle:"+childFile.getPath());
        //获取所有目录下的文件名数组
        System.out.println(Arrays.toString(dir.list()));

        System.out.println(Arrays.toString(File.listRoots()));
    }
}
