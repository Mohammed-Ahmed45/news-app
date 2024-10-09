package Base

data class UiMessage(
    var showLodaing:Boolean ?=null,
    var message:String ?=null,
    var messageId: Int ?=null,

    var posButtonId:Int ?=null,
    var posButtonText:String ?=null,
    var onPosClick:OnDialogClick ?=null,

    var negButtonId:Int ?=null,
    var negButtonText:String ?=null,
    var onNegClick:OnDialogClick ?=null,

    var isCancelable:Boolean =true,
    var exeption:Throwable ?=null

)
fun interface OnDialogClick
{
    fun  onClick()
}
