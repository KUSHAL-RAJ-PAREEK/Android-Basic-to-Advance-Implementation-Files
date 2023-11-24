# Android-Basic-to-Advance-Implementation-Files

Hello everyone this is my contribution for all but to use it properly you need to follow this steps:-

as we know now ("kotlin-android-extensions") plugin is deprecated in upper project it is used so please follow this steps to apply view binding:-
1. in app level gradel enable viewbinding in android section by buildforces.
2. now initilize binding in your kotlin activity:-
   the binding code is:-
   ////////////////////////////////////////////////////
   private lateinit var binding: ResultProfileBinding
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ResultProfileBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
}
 ////////////////////////////////////////////////////
3. now use binding keyword or anyelse which you mention in latinit before viwes.
   like :- before
           button.setOnClicklistner{}

           After binding:-
         binding.button.setOnClicklistner{}

   for more information read:-
   https://developer.android.com/topic/libraries/view-binding

   thank you.
