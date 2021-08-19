package com.example.demo.fastdfs;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author cfy
 * @Date 2021-4-20 下午 4:29
 * @Version 1.0
 */
public class FastDFS {
    public static void main(String[] args) {
        downloadFilesWithFastdfs();

    }
        static void upload(){
            try {
                //1、 初始化fastdfs客户端配置文件
                ClientGlobal.init("D:\\workspace\\test\\demo\\src\\main\\resources\\fdfs_client.conf");// 加载properties配置文件
                System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");//输出properties中配置的参数，检测properties文件是否生效
                System.out.println("charset=" + ClientGlobal.g_charset);

                //2、 创建tracker的客户端
                TrackerClient tracker = new TrackerClient();// 创建tracker客户端对象
                TrackerServer trackerServer = tracker.getConnection();//获得tracker连接对象
                //3、创建storage的客户端
                StorageServer storageServer = null;
            /*在properties文件中只需要配置tracker服务器的ip，storage的ip通过tracker服务器来获取
            获取storage
*/
                StorageClient1 client = new StorageClient1(trackerServer, storageServer);//4、通过tracker服务器返回storage服务器对象（客户端）

                //设置文件元信息这里只上传一个文件
                NameValuePair[] metaList = new NameValuePair[1];
                metaList[0] = new NameValuePair("testUpload", "");//
                String fileId = client.upload_file1("C:\\Users\\38987\\Desktop\\redis笔记.docx", null, metaList);//上传 本地电脑文件（完整路径）到storage服务器
                System.out.println("upload success. file id is: " + fileId);//上传成功返回文件id，如果storage服务器配置了nginx服务器 可以通过ip+fileId来访问到上传的文件
//            下载文件
//            int i = 0;
//            while (i++ < 10) {
//                byte[] result = client.download_file1(fileId);//下载文件操作
//                System.out.println(i + ", download result is: " + result.length);
//            }

                trackerServer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        static void down(){
            try {
                //1.初始化fastdfs客户端配置文件
                ClientGlobal.init("D:\\workspace\\test\\demo\\src\\main\\resources\\fdfs_client.conf");// 加载properties配置文件
                System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");//输出properties中配置的参数，检测properties文件是否生效
                System.out.println("charset=" + ClientGlobal.g_charset);

                // 2.获取trackerServer
                TrackerClient tracker = new TrackerClient();// 创建tracker客户端对象
                TrackerServer trackerServer = tracker.getConnection();//获得tracker连接对象

                //3.获取storageClient（通过trackerServer 和 storageServer：null）
                StorageServer storageServer = null;
                StorageClient1 client = new StorageClient1(trackerServer, storageServer);//通过tracker服务器返回storage服务器对象（客户端）

                //4.下载操作
                //方式一 文件id下载
                System.out.println(client);
                byte[] bytes = client.download_file1("group1/M00/00/04/rB4BGWB-nOaATr8JAAA09p9X5rw23.docx");//记得要传文件id返回字节流
                System.out.println(bytes.toString());
                File file=new File("C:\\Users\\38987\\Desktop\\cc.docx");// 给定文件路径 和 名称
                FileOutputStream fileOutputStream=new FileOutputStream(file);//窗机输出流
                fileOutputStream.write(bytes);//写入数据
                fileOutputStream.close();//关闭输出流

                //方式二 组名+文件路径
//                byte[] bytes2 = client.download_file("group1","M00/00/00/wKgByl3hXDiAR662AAFLbNXkMmY992.jpg");//记得修改
//                File file2=new File("/home/angel/test2.jpg");// 给定文件路径 和 名称
//                FileOutputStream fileOutputStream2=new FileOutputStream(file2);//窗机输出流
//                fileOutputStream2.write(bytes);//写入数据
//                fileOutputStream2.close();//关闭输出流


                trackerServer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    public static void downloadFilesWithFastdfs(){}
//        String path = request.getSession().getServletContext().getRealPath("/");//表示到项目的根目录下，要是想到目录下的子文件夹，修改"/"即可
//        path = path.replaceAll("\\\\", "/");
//        @GateKeeper(gates = ["project-in"])
//        @ApiOperation("文档下载")
////    @GetMapping("/{projectId}/{filePath}/download")
//        @GetMapping("/{projectId}/download")
//        @Throws(FileNotFoundException::class)
//        fun download(@PathVariable projectId: String, @RequestParam("fileId") filePath: String,response:
//        HttpServletResponse) {
////        val realName = fileName.split("es-task-file-")[1]
////        val inStream: InputStream = FileInputStream(uploadPath + fileName)
////        FileUtil.download(response, realName, inStream)
//            iFastDfsFile.download(projectId,filePath,response)
//        }
//
//
//
//
//    , response: HttpServletResponse
//
//
//        var CONF_FILENAME = Thread.currentThread().getContextClassLoader().getResource("fdfs_client.conf").getPath();
//
//
//        try {
//            val trackerClient = TrackerClient()
//            trackerServer = trackerClient.getConnection()
//            storageServer = trackerClient.getStoreStorage(trackerServer, "")
//            storageClient1 = StorageClient1(trackerServer, storageServer)
//            val bytes = storageClient1.download_file1(fileId)
//            val fileEnd = fileId.substring(fileId.indexOf(".")+1)
//            response.reset()
//            when(fileEnd){
//                "doc" -> response.contentType = "application/msword"
//                "xls" -> response.contentType = "application/vnd.ms-excel"
//                "xlsx" -> response.contentType = "application/vnd.ms-excel"
//                "docx" -> response.contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
//                "jpg" -> response.contentType = "image/jpeg"
//                "zip" -> response.contentType = "application/zip"
//            }
//            response.setCharacterEncoding("utf-8")
//            response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("下载文件", "UTF-8"))
//            response.outputStream.write(bytes)
//            response.outputStream.close()
//    }
}
