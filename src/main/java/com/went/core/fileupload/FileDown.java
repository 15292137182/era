package com.went.core.fileupload;

import org.springframework.stereotype.Controller;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Shanghai Batchsight GMP Information of management platform, Inc. Copyright(c) 2017</p>
 *
 * @author Wen TieHu
 * @version 1.0
 *          <pre>History: 2017/11/17  Wen TieHu Create </pre>
 */
@Controller
public class FileDown {

//  @RequestMapping("/down")
//  public @ResponseBody void fileDown(HttpServletRequest request, HttpServletResponse response) {
//    response.setContentType("application/X-msdownload");
//    response.setHeader("Content-Disposition", "attachment;filename=test.zip");
////    NutFilePool nutFilePool = SpringContextHolder.getBean("nutFilePool");
////    File nutFilePoolFile = nutFilePool.getFile(17, ".jpg");
//    ZipOutputStream zos;
//    try {
//      zos = new ZipOutputStream(response.getOutputStream());
////      File file = new File(nutFilePoolFile.getPath());
////      zos.putNextEntry(new ZipEntry(nutFilePoolFile.getName()));
////      FileInputStream fis = new FileInputStream(file);
//      byte b[] = new byte[1024];
//      int n = 0;
//      while ((n = fis.read(b)) != -1) {
//        zos.write(b, 0, n);
//      }
//      zos.flush();
//      fis.close();
//      zos.flush();
//      zos.close();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
}
