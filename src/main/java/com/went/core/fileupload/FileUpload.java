package com.went.core.fileupload;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.went.core.utils.UtilsTool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>Title: FileUpload</p>
 * <p>Description: 文件上传</p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/17  Wen TieHu Create </pre>
 */


public class FileUpload extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String attachmentRowId = req.getParameter("attachmentRowId");
    String message = "";
    int state;
    if (UtilsTool.isValid(attachmentRowId)) {
//      NutFilePool nutFilePool = SpringContextHolder.getBean("nutFilePool");
      try {
        //设置保存文件的目录
        String filePath = getServletContext().getRealPath("/") + "file";
        //修改文件存放路径
//        Global.modifyProperties("file.upload.url", filePath);
        SmartUpload smartUpload = new SmartUpload();
        //初始化smart组件
        smartUpload.initialize(getServletConfig(), req, resp);
        //设置文件总大小
        smartUpload.setMaxFileSize(1024 * 1024);
        //设置所有文件的总大小
        smartUpload.setTotalMaxFileSize(1024 * 1024 * 10);
        //设置允许上传文件的类型
        smartUpload.setAllowedFilesList("txt,jpg,gif,doc,docx,xls,xlsx,ppt");
        //从smartUpload对象获取文件信息
        Files files = smartUpload.getFiles();
        smartUpload.upload();
        for (int i = 0; i < files.getCount(); i++) {
          //获取文件信息
          com.jspsmart.upload.File filesFile = files.getFile(i);
          //获取文件大小
          long size = filesFile.getSize();
          //获取文件名称信息
          String fileName = filesFile.getFileName();
          //文件名称编码修改
          String fileNames = new String(fileName.getBytes("GBK"), "UTF-8");
          String suffix = fileNames.split("\\.")[1];
          //创建文件
//          File file = nutFilePool.createFile("." + suffix);
          //保存文件
//          filesFile.saveAs(file.toPath().toFile().getPath());
        }
        message = String.format("上传成功,共上传%s个文件", files.getCount());
        state = 1;
      } catch (Exception e) {
        if (e.getMessage().contains("1015")) {
          message = "上传失败,文件类型禁止上传";
        } else if (e.getMessage().contains("1010")) {
          message = "上传失败,文件后缀名不是允许的上传类型";
        } else if (e.getMessage().contains("1105")) {
          message = "上传失败,单个文件超过允许文件大小的最大值";
        } else if (e.getMessage().contains("1110")) {
          message = "上传失败,上传文件总大小超过所有文件的总大小允许的最大值";
        }
        state = -1;
      }
    } else {
//      message = getMessage(Message.DATA_CANNOT_BE_EMPTY);
      state = -1;
    }
//    ServletUtils.writeJsonToResponse(PlatResult.success(new ServerResult().setStateMessage(state, message)), resp);
  }
}