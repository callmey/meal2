package test;
import java.awt.*;
import java.awt.print.*;
public class ImagePrint{
 protected Image printImage;
 
 public static void main(String[] args) 
 {
  ImagePrint ip = new ImagePrint(args[0]);
  System.exit(0);
 }

 public ImagePrint(String fileName){
  printImage = new javax.swing.ImageIcon(fileName).getImage(); //�̹������ϻ���
  Paper p = new Paper();

  //��µ� ���� ����
  p.setImageableArea(1*72,  //Left margin 1 inch      //for mm 0.0395
          1.5*72, //Top margin 1.5 inches
          6.5*72, //Width 6.5 inches
          8*72);  //Height 8 inches
  PageFormat format = new PageFormat();
  format.setPaper(p);  //���������� ���������������� ���ڷ�..
  PrinterJob pj = PrinterJob.getPrinterJob();
  pj.setPrintable(new MyPrintable(), format);  
  try{
   pj.print();
  }catch(PrinterException pe){
   System.out.println("Printingfailed : "+pe.getMessage());
  }
 }

 class MyPrintable implements Printable{
  public int print(Graphics g, PageFormat pf, int pageIndex){
   g.translate((int)(pf.getImageableX()), (int)(pf.getImageableY()));
   
   if(pageIndex == 0){
    g.drawImage(printImage, 0, 0, null);
    return Printable.PAGE_EXISTS;
   }
   return Printable.NO_SUCH_PAGE;
  }
 }
}

