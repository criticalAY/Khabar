package com.criticalay.khabar.utils

import com.criticalay.khabar.data.Khabar
import com.google.gson.Gson

fun getSampleData():Khabar {
    // Parse the JSON string containing sample data
    val jsonString = """
    {
    "status": "ok",
    "totalResults": 38,
    "articles": [
        {
            "source": {
                "id": null,
                "name": "The Indian Express"
            },
            "author": "The Indian Express",
            "title": "Black holes existed at the dawn of time, birthing new stars, finds study - The Indian Express",
            "description": null,
            "url": "https://indianexpress.com/article/technology/science/supermassive-black-holes-dawn-of-time-9151229/",
            "urlToImage": null,
            "publishedAt": "2024-02-08T12:25:44Z",
            "content": null
        },
        {
            "source": {
                "id": null,
                "name": "Moneycontrol"
            },
            "author": "Moneycontrol News",
            "title": "Sennheiser launches Accentum Plus wireless headphones in India - Moneycontrol",
            "description": "The Accentum Plus has been priced at Rs 15,900 in India, and will be available on Sennheiser's official online store and Amazon India starting February 14",
            "url": "https://www.moneycontrol.com/news/technology/sennheiser-launches-accentum-plus-wireless-headphones-in-india-12225101.html",
            "urlToImage": "https://images.moneycontrol.com/static-mcnews/2024/02/gsmarena_001-653x435.jpg",
            "publishedAt": "2024-02-08T12:00:04Z",
            "content": "German audio company Sennheiser has launched the Accentum Plus wireless headphones in India. The Accentum Plus has been priced at Rs 15,900 in India, and will be available on Sennheiser's official on… [+1173 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "The Quint"
            },
            "author": "Pranay Dutta Roy",
            "title": "Pakistan Election 2024 Live Updates: Voting Enters Final Stage, Mobile Service Suspended; Polling Extended in Some Areas - The Quint",
            "description": "Pakistan Election 2024 - Get latest news and live updates on Pakistan General elections voting including election news, photos, videos, Pakistan election result date, exit poll results date, time and many more at The Quint.",
            "url": "https://www.thequint.com/news/world/pakistan-election-2024-live-updates-pak-general-elections-voting-latest-news",
            "urlToImage": "https://images.thequint.com/thequint%2F2024-02%2Fc445b768-6750-4edd-b2a4-bac5dbcef32f%2FPAKISTAN_ELECTION.png",
            "publishedAt": "2024-02-08T11:38:53Z",
            "content": "Pakistan Election 2024 Voting Live Updates: Embattled by political, economic, and judicial crises over the course of the last few years, Pakistan voted in its long-delayed general election on Thursda… [+379 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "India Today"
            },
            "author": "India Today News Desk",
            "title": "INDIA bloc dominates in Tamil Nadu with 39/39 seats: Mood of the Nation poll - India Today",
            "description": "As per the Mood of the Nation poll by India Today Group the Opposition alliance is projected to win 47 per cent of the vote share in Tamil Nadu",
            "url": "https://www.indiatoday.in/india/story/clean-sweep-india-bloc-tamil-nadu-predicts-mood-of-the-nation-2499267-2024-02-08",
            "urlToImage": "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202402/mk-stalin-084921998-16x9_0.jpg?VersionId=gYvyrs3t5o_kKyKgvefrHDoSmGOfCZXR",
            "publishedAt": "2024-02-08T11:24:55Z",
            "content": "The Mood of the Nation poll by India Today Group suggests a clean sweep by the INDIA bloc in Tamil Nadu. The survey predicts INDIA bloc's victory on all 39 Lok Sabha seats.\r\nThe Mood of the Nation's … [+900 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "Livemint"
            },
            "author": "Livemint",
            "title": "'They are interfering in our internal affairs': India on Canada's election interference change | Mint - Mint",
            "description": "'We have seen media reports about the Canadian commission enquiring into ...We strongly reject all such baseless allegations of Indian interference in Canadian elections,' External Affairs Ministry Spokesperson Randhir Jaiswal said.",
            "url": "https://www.livemint.com/news/india/india-rejects-canadas-claim-of-interfering-in-canadian-elections-hardeep-singh-nijjar-11707389535358.html",
            "urlToImage": "https://www.livemint.com/lm-img/img/2024/02/08/1600x900/MEA-spokesperson-Randhir-Jaiswal--Twitter-Photo-_1707390985378_1707390996926.png",
            "publishedAt": "2024-02-08T11:04:28Z",
            "content": "India on Thursday categorically denied the allegation levelled by Canadian agencies of interference  and marked India as a 'foreign interference threat' that could potentially interfere in Canadian e… [+2775 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "YouTube"
            },
            "author": null,
            "title": "NASA climate satellite blasts off Thursday morning - 10 Tampa Bay",
            "description": "NASA’s newest climate satellite rocketed into orbit Thursday to survey the world’s oceans and atmosphere in never-before-seen detail.SpaceX launched the Pace...",
            "url": "https://www.youtube.com/watch?v=1bvAZgAP57E",
            "urlToImage": "https://i.ytimg.com/vi/1bvAZgAP57E/hqdefault.jpg",
            "publishedAt": "2024-02-08T10:40:45Z",
            "content": null
        },
        {
            "source": {
                "id": null,
                "name": "Moneycontrol"
            },
            "author": "Moneycontrol News",
            "title": "Taking Stock: Sensex, Nifty plunge after RBI keeps rates unchanged; BFSI, auto see selling - Moneycontrol",
            "description": "Banks, financial services and auto — all rate sensitive stocks — were under selling pressure during the day",
            "url": "https://www.moneycontrol.com/news/business/markets/taking-stock-sensex-nifty-plunges-after-rbi-keeps-rates-unchanged-bfsi-auto-see-selling-12224711.html",
            "urlToImage": "https://images.moneycontrol.com/static-mcnews/2024/02/Sensex_nifty_market_down_Sensex-770x433.jpg",
            "publishedAt": "2024-02-08T10:27:00Z",
            "content": "The equity benchmarks the Sensex and the Nifty ended February 8 sharply lower following the status quo maintained by the Reserve Bank of India (RBI) on key interest rates. The market has fluctuated i… [+3090 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "NDTV News"
            },
            "author": null,
            "title": "Yami Gautam And Aditya Dhar Are Expecting Their First Child Together: \"There Is A Baby On Its Way\" - NDTV Movies",
            "description": "\"I really don't know what I would have done had Aditya not been there by my side,\" said mom-to-be Yami Gautam",
            "url": "https://www.ndtv.com/entertainment/yami-gautam-and-aditya-dhar-are-expecting-their-first-child-together-there-is-a-baby-on-its-way-5018445",
            "urlToImage": "https://c.ndtvimg.com/2024-02/qfddnkk_alia-_625x300_08_February_24.jpg",
            "publishedAt": "2024-02-08T10:24:12Z",
            "content": "Parent-to-be Yami and Aditya at Article 370 trailer launch event\r\nNew Delhi: OMG 2 actress Yami Gautam and filmmaker Aditya Dhar are expecting their first child together. The happy news was confirmed… [+1423 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "India Today"
            },
            "author": "India Today Information Desk",
            "title": "Keto Diet and Weight Loss: What you need to know? - India Today",
            "description": "There are a lot of things you need to know before you dive into the deep sea of ketosis",
            "url": "https://www.indiatoday.in/information/story/keto-diet-and-weight-loss-what-you-need-to-know-2499286-2024-02-08",
            "urlToImage": "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202402/keto-diet-and-weight-loss-what-you-need-to-know-081057169-16x9_0.jpg?VersionId=HMRSZoWauPF09KvrhAEj8czD_pFYAjJj",
            "publishedAt": "2024-02-08T10:15:04Z",
            "content": "‘Diet’, the dreaded D word. It is preceded by a month of research about what is the latest trend, two months of tossing into another ‘Mondays’ to start with and god knows how many into scrolled motiv… [+2421 chars]"
        },
        {
            "source": {
                "id": "the-times-of-india",
                "name": "The Times of India"
            },
            "author": "Shafaque Alam",
            "title": "Heavy traffic jam on Noida Expressway amid farmer's protest - Times of India",
            "description": "NOIDA: Delhi Noida Traffic: There is heavy traffic jam on Noida Expressway as traffic police have placed barricades to stop farmers march from Noida t.",
            "url": "https://timesofindia.indiatimes.com/city/noida/heavy-traffic-jam-on-noida-expressway-amid-farmers-protest/articleshow/107523788.cms",
            "urlToImage": "https://static.toiimg.com/thumb/msid-107523789,width-1070,height-580,imgsize-1794870,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg",
            "publishedAt": "2024-02-08T10:07:00Z",
            "content": "Only these 10 animals came to bid farewell to God as per legend"
        },
        {
            "source": {
                "id": null,
                "name": "Hindustan Times"
            },
            "author": "HT Sports Desk",
            "title": "‘Jasprit Bumrah the most complete bowler in the world’: South Africa great - Hindustan Times",
            "description": "Vernon Philander said Jasprit Bumrah doesn't seem to have any chinks in his armour. | Cricket",
            "url": "https://www.hindustantimes.com/cricket/jasprit-bumrah-the-most-complete-bowler-in-the-world-former-south-africa-pacer-vernon-philander-101707385731176.html",
            "urlToImage": "https://www.hindustantimes.com/ht-img/img/2024/02/08/1600x900/ANI-20240205096-0_1707385802964_1707385826252.jpg",
            "publishedAt": "2024-02-08T09:59:48Z",
            "content": "The accolades keep flowing for Jasprit Bumrah. After rattling England in what is being hailed as one of the best displays by any fast bowler in a Test match in India, Bumrah became the first Indian p… [+2366 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "BusinessLine"
            },
            "author": "BL Internet Desk",
            "title": "RBI MPC Meeting Highlights February 2024: Repo rate unchanged at 6.5%; actions against Paytm are in the best interest of systemic stability, says Shaktikanta Das - BusinessLine",
            "description": "RBI Monetary Policy Meeting Highlights, RBI MPC Meeting February 2024 News & Key Highlights: The Reserve Bank of India’s Monetary Policy Committee has decided to keep the policy repo rate unchanged at 6.5%.",
            "url": "https://www.thehindubusinessline.com/money-and-banking/rbi-monetary-policy-committee-mpc-meeting-live-updates-and-news-february-2024/article67821785.ece",
            "urlToImage": "https://bl-i.thgim.com/public/incoming/l504x4/article67731319.ece/alternates/LANDSCAPE_1200/PTI12_08_2023_000096A.jpg",
            "publishedAt": "2024-02-08T09:56:15Z",
            "content": "<li></li>\r\nFebruary 08, 2024 15:25RBI monetary policy news: RBI says no systemic worries, action on Paytm due to persisted non-compliance\r\nReserve Bank Governor Shaktikanta Das said that there are no… [+29130 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "NDTV News"
            },
            "author": null,
            "title": "After Rahul Gandhi's \"PM Not OBC\" Claim, Government's Fact-Check - NDTV",
            "description": "The government on Thursday afternoon hit back at Rahul Gandhi after the Congress MP's claim Prime Minister Narendra Modi was not born into an Other Backward Class community.",
            "url": "https://www.ndtv.com/india-news/rahul-gandhi-pm-modi-obc-family-centre-hits-back-after-rahul-gandhis-pm-not-born-in-obc-family-claim-5018077",
            "urlToImage": "https://c.ndtvimg.com/2024-02/dsakp6i_rahul-gandhi-narendra-modi-rahul-modi-split_625x300_08_February_24.jpg?im=FeatureCrop,algorithm=dnn,width=1200,height=738?ver-20240117.06",
            "publishedAt": "2024-02-08T09:21:59Z",
            "content": "Congress MP Rahul Gandhi and Prime Minister Narendra Modi (File).\r\nNew Delhi: The government on Thursday afternoon hit back at Rahul Gandhi after the Congress Lok Sabha MP's claim that Prime Minister… [+3418 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "The Indian Express"
            },
            "author": "The Indian Express",
            "title": "Gokulpuri metro station boundary wall collapses; one dead, DMRC to give Rs 15 lakh to kin - The Indian Express",
            "description": null,
            "url": "https://indianexpress.com/article/cities/delhi/portion-of-gokul-puri-metro-station-collapses-one-critically-injured-9150438/",
            "urlToImage": null,
            "publishedAt": "2024-02-08T09:21:55Z",
            "content": null
        },
        {
            "source": {
                "id": null,
                "name": "Livemint"
            },
            "author": "Livemint",
            "title": "ED issues summons to Congress MP Dhiraj Sahu in money laundering probe - Mint",
            "description": "Congress MP Dhiraj Sahu has been summoned by the Enforcement Directorate (ED) in connection with his alleged links to former Jharkhand CM Hemant Soren and a seized BMW SUV.",
            "url": "https://www.livemint.com/news/ed-summons-congress-mp-dhiraj-sahu-in-money-laundering-probe-against-hemant-soren-11707380049087.html",
            "urlToImage": "https://www.livemint.com/lm-img/img/2024/02/08/1600x900/ed_1681357106377_1707380796552.png",
            "publishedAt": "2024-02-08T08:40:21Z",
            "content": "The Enforcement Directorate (ED) has issued summons to Congress MP Dhiraj Sahu on February 10, in former Jharkhand CM Hemant Soren case.  The ED wants to question and record Sahu's statement in conne… [+2103 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "Hindustan Times"
            },
            "author": "HT News Desk",
            "title": "Parliament Budget Session LIVE: Kharge urges members to have more discussions - Hindustan Times",
            "description": "Parliament Budget Session LIVE: A white paper is a govt document which is presented to highlight new policies & achievements to gain support.",
            "url": "https://www.hindustantimes.com/india-news/parliament-budget-session-live-updates-rajya-sabha-lok-sabha-bill-latest-news-today-february-8-2024-101707353159909.html",
            "urlToImage": "https://www.hindustantimes.com/ht-img/img/2024/02/08/550x309/Nirmala_Sitharaman_1707386908722_1707386908907.jpg",
            "publishedAt": "2024-02-08T08:30:03Z",
            "content": "Parliament Budget Session LIVE: Union Finance Minister Nirmala Sitharaman on Thursday tabled a white paper on the \"mismanagement\" of the economy during the previous Congress governments in the Lok Sa… [+10755 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "Sporting News"
            },
            "author": null,
            "title": "Inter Miami urged to provide 'reasonable explanations' why Lionel Messi was able to play against Vissel Kobe by Hong Kong government as tour controversy continues - Goal.com",
            "description": "Get all the latest Soccer news, highlights, scores, schedules, standings and more from Sporting News Canada.",
            "url": "https://www.sportingnews.com/ca/soccer",
            "urlToImage": "https://static.sportingnews.com/1.43.0.8/themes/custom/tsn/logo.jpg",
            "publishedAt": "2024-02-08T08:10:35Z",
            "content": null
        },
        {
            "source": {
                "id": null,
                "name": "123telugu.com"
            },
            "author": null,
            "title": "Yatra 2 Telugu Movie Review | Mammootty, Jiiva | 123telugu - 123telugu",
            "description": "Yatra 2 Telugu Movie Review, Yatra 2 review, Mammootty, Jiiva, YSR, Jagan Mohan Reddy, Yatra 2 movie review in telugu, Yatra movie review and ratings, Yatra 2",
            "url": "https://www.123telugu.com/mnews/yatra-2-telugu-movie-review.html",
            "urlToImage": "https://www.123telugu.com/content/wp-content/themes/123telugu/images/logo.gif",
            "publishedAt": "2024-02-08T08:08:31Z",
            "content": "Movie Name : Yatra 2\r\nRelease Date : February 08, 2024\r\n 123telugu.com Rating : 3/5 \r\nStarring: Mammootty, Jiiva, Ketaki Narayan, Suzanne Bernert, Mahesh Manjrekar, Ashrita Vemuganti Nanduri\r\nDirecto… [+3468 chars]"
        },
        {
            "source": {
                "id": null,
                "name": "OpIndia"
            },
            "author": "OpIndia",
            "title": "Uttarakhand Uniform Civil Code doesn’t interfere with Islamic faith, no problem accepting it: Waqf Board - OpIndia",
            "description": null,
            "url": "https://www.opindia.com/2024/02/uttarakhand-uniform-civil-code-doesnt-interfere-with-islamic-faith-no-problem-accepting-waqf-board/",
            "urlToImage": null,
            "publishedAt": "2024-02-08T07:51:05Z",
            "content": null
        },
        {
            "source": {
                "id": null,
                "name": "CNBCTV18"
            },
            "author": "Mangalam Maloo",
            "title": "ITC's largest shareholder BAT is working towards monetising some of its stake - CNBCTV18",
            "description": "BAT had earlier highlighted to analysts in December last year that they are open to paring stake in ITC.",
            "url": "https://www.cnbctv18.com/market/itc-share-price-bat-largest-shareholder-monetising-stake-value-cigarette-hotels-19005881.htm",
            "urlToImage": "https://images.cnbctv18.com/wp-content/uploads/2023/08/ITC-shutterstockk-1019x573.jpg",
            "publishedAt": "2024-02-08T07:33:08Z",
            "content": "Let's Connect with CNBCTV 18\r\n©TV18 Broadcast Limited. All rights reserved."
        }
    ]
}
    """.trimIndent()

    // Parse the JSON string into a KhabarResponse object using Gson or any other JSON parsing library
    val khabarResponse = Gson().fromJson(jsonString, Khabar::class.java)

    // Return the list of articles
    return khabarResponse
}
