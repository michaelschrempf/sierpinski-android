package at.fh.swengb.sierpinski_android

import android.content.Context
import android.graphics._
import android.util.AttributeSet
import android.view.View

class SierpinskiTriangle(val context: Context, val attrs: AttributeSet) extends View(context, attrs) {


  val recursionDepth = 8
  val paint = new Paint()


  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    val x = canvas.getWidth

    val y = Math.sqrt(x * x - x/2 * x/2).toFloat

    drawFirstTriangle(x, y, x/2, 0, 0, y, canvas)
  }

  def drawFirstTriangle(x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float, canvas: Canvas) = {
    canvas.drawLines(Array(x3, y3, x2, y2, x2, y2, x1, y1, x1, y1, x3, y3), paint)
    triangles(recursionDepth, (x1 + x2)/2, (y1 + y2)/2, (x1 + x3)/2, (y1 + y3)/2, (x2 + x3)/2, (y2 + y3)/2, canvas)
  }



  def triangles(recursionDepth: Int, x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float, canvas: Canvas):Unit = {
    if (recursionDepth > 0){
      canvas.drawLines(Array(x1, y1, x2, y2, x2, y2, x3, y3, x3, y3, x1, y1), paint)
      val newDepth = recursionDepth - 1
      triangles(newDepth, (x1 + x2)/2 + (x2 - x3)/2, (y1 + y2)/2 + (y2 - y3)/2, (x1 + x2)/2 + (x1 - x3)/2, (y1 + y2)/2 + (y1 - y3)/2, (x1 + x2)/2, (y1 + y2)/2, canvas)
      triangles(newDepth, (x3 + x2)/2 + (x2 - x1)/2, (y3 + y2)/2 + (y2 - y1)/2, (x3 + x2)/2 + (x3 - x1)/2, (y3 + y2)/2 + (y3 - y1)/2, (x3 + x2)/2, (y3 + y2)/2, canvas)
      triangles(newDepth, (x1 + x3)/2 + (x3 - x2)/2, (y1 + y3)/2 + (y3 - y2)/2, (x1 + x3)/2 + (x1 - x2)/2, (y1 + y3)/2 + (y1 - y2)/2, (x1 + x3)/2, (y1 + y3)/2, canvas)
    }
  }
}