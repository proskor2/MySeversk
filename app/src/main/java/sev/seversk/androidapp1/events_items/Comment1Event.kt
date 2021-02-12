package sev.seversk.androidapp1.events_items

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liftric.kvault.KVault
import kotlinx.android.synthetic.main.activity_comments1.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.R
import sev.seversk.androidapp1.comment.*

class Comment1Event : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments1)

                lateinit var recyclerView: RecyclerView
                lateinit var recyclerAdapter: CommentAdapter

                val intent2 = intent.extras
                val idevent = intent2?.get("idevent").toString().toInt()
                val idevent2 = intent2?.get("idevent").toString()

                val kVault = KVault(context = applicationContext)
                val token = kVault.string("TOKEN")
                val token2: String = "Bearer $token"

                recyclerView = findViewById(R.id.recycler_coomentnews)
                recyclerAdapter = CommentAdapter(this)
                recycler_coomentnews.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = recyclerAdapter

                recyclerView.setOnClickListener(){
                    hideKeyboard()
                }

                findViewById<LinearLayout>(R.id.linear_comm).setOnClickListener(){
                    hideKeyboard()
                }
                val apiinterface = ApiEventComment.create().getComment(idevent, token2)

                apiinterface.enqueue(object : Callback<comments> {
                    override fun onResponse(call: Call<comments>, response: Response<comments>?) {
                        val resp = response?.body()
// Get title
                        val title = resp?.title
                        findViewById<TextView>(R.id.text_comments_namenews).text = title
// Get arraylist comments
                        val listcomm = resp?.comments?.toList()
                        val size = listcomm?.size

                        if (response?.body() != null){
                            recyclerAdapter.setCommentListItems(listcomm)
                        }

                    }

                    override fun onFailure(call: Call<comments>, t: Throwable) {
                        Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_LONG).show()
                    }
                })


//// Post Comment
                val ownName = "Afisha"

                class RestSendComment {
                    val kVault = KVault(context = applicationContext)
                    val token2 = kVault.string("TOKEN")
                    fun sendnewComment(sendComm: sendComment, onResult: (sendComment?) -> Unit) {
                        val retrofit = ServiceBuliderCommN.buildService(ApiSendCommentNews::class.java)
                        retrofit.sendComment(sendComm, token2, ownName, idevent2)
                            .enqueue(
                                object : Callback<sendComment> {
                                    override fun onFailure(call: Call<sendComment>, t: Throwable) {
                                        onResult(null)
                                    }

                                    override fun onResponse(
                                        call: Call<sendComment>,
                                        response: Response<sendComment>
                                    ) {
                                        val sendingComment = response.body()
                                        onResult(sendingComment)
                                    }
                                }
                            )
                    }
                }

                fun sendCommentsNew(comment_text: String) {
                    val apiService = RestSendComment()
                    val sendCom = sendComment(
                        comment_id = null,
                        comment_text = comment_text,
                        create_time = null,
                        user = null,
                        status = null
                    )

                    apiService.sendnewComment(sendCom) {
                        if (it?.comment_text != null) {
                        } else {
                            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
/// Click Send comment
                findViewById<ImageButton>(R.id.button_sendcomment).setOnClickListener(){
                    Toast.makeText(this, "Ваше сообщение отправлено на модерацию", Toast.LENGTH_LONG).show()
                    val textcom = findViewById<EditText>(R.id.text_sendcomment).text.toString()
                    sendCommentsNew(textcom)
                    hideKeyboard()
//            recreate()
                }
// Click close comment
                findViewById<ImageButton>(R.id.button_close_comment).setOnClickListener() {

                    finish()

                }
            }
            fun AppCompatActivity.hideKeyboard() {
                val view = this.currentFocus
                if (view != null) {
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                } else {
                    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                }
            }

        }
