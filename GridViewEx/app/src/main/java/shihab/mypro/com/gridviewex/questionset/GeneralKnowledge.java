package shihab.mypro.com.gridviewex.questionset;

/**
 * Created by shihab on 11/14/2017.
 */

public class GeneralKnowledge {

    public String mQuestion[] = {
            "ষাট গম্বুজ মসজিদের প্রতিষ্ঠা হয় কবে?",
            "জাতীয় ই-তথ্য কোষ চালু হয় কবে?",
            "একসময় বাংলাদেশের দ্বিতীয় পার্লামেন্ট বলা হত কোনটিকে?",
            "কেন্দ্রীয় শহীদ মিনারের মূল বেদীর ওপর অর্ধ-বৃত্তাকারে সাজানো কয়টি স্তম্ভ আছে?",
            "বিশ্বের দীর্ঘতম মেরিন ড্রাইভ কোনটি?",
            "সর্বপ্রথম ঢাকা বাংলার রাজধানী হয় কবে?",
            "ক্ষুদ্রতম নদী কোনটি?",
            "দেশের ৩০ তম নদীবন্দর কোনটি?",
            "দেশের স্থল বন্দর ২৩তম স্থলবন্দর কোনটি?",
            "জালিয়ার দ্বীপ কোথায় অবস্থিত?"

    };

    private String mChoice[][]={
            {"A.১৩৪৫","B.১৪৫৯","C.১৬৫০","D.১৭৫৭"},
            {"A.২০১১","B.২০১২","C.২০১৩","D.২০১৪"},
            {"A.ছাত্র ঐক্য","B.ছাত্র সঙ্ঘ","C.ছাত্র সমিতি","D.ডাকসু"},
            {"A.৫টি স্তম্ভ","B.৪টি স্তম্ভ","C.৬টি স্তম্ভ","D.৭টি স্তম্ভ"},
            {"A.সীতাকুণ্ড-চট্টগ্রাম","B.কক্সবাজার-টেকনাফ","C.চট্টগ্রাম-কক্সবাজার","D.টেকনাফ-সেন্ট মার্টিন"},
            {"A.১৬১০","B.১৬১১","C.১৬১২","D.১৬১৩"},
            {"A.তুরাগ নদী","B.রো নদী","C.ওহিও নদী","D.লাল নদী"},
            {"A.ঝিনাইদহ","B.সুনামগঞ্জ","C.কুমিল্লা","D.ফেনী"},
            {"A.বাল্লা, ময়মনসিংহ","B.বাল্লা, সিলেট","C.বাল্লা, ফেনী","D.বাল্লা, ঠাকুরগাঁও"},
            {"A.নাফ নদীর মাঝখানে","B.বরিশাল","C.ভোলায়","D.বার্মা"}
    };



    private String correctAns[]={
            "B","A","D","A","B","A","B","B","B","A"
    };



    public String getQustion(int index){
        String question = mQuestion[index];
        return question;
    }


    public String getCorrectAns(int index){
        String ans = correctAns[index];
        return ans;
    }


    public String getChoice(int index){
        String choice = mChoice[index][0];
        return choice;
    }

    public String getChoice1(int index){
        String choice = mChoice[index][1];
        return choice;
    }

    public String getChoice2(int index){
        String choice = mChoice[index][2];
        return choice;
    }

    public String getChoice3(int index){
        String choice = mChoice[index][3];
        return choice;
    }



}
