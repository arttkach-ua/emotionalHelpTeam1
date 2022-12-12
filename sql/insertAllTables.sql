
INSERT IGNORE INTO emotional_help.questionnaires (id, name,description) VALUES
	 (1,'Heck method','Methods for express diagnosis of heck and hess neuroses'),
	 (2,'Beck Depression Inventory BDI-II','Beck Depression Inventory BDI-II');

INSERT IGNORE INTO emotional_help.questions (id,questionnaires_id,name) VALUES
	 (1,1,'1. Do you feel that you are internally tense? '),
	 (2,1,'2. I am often so wrapped up in something that I cannot sleep.'),
	 (3,1,'3. I feel easily hurt. '),
	 (4,1,'4. I find it difficult to talk to strangers. '),
	 (5,1,'5. Do you often feel listless and tired for no particular reason? '),
	 (6,1,'6. I often get the feeling that people are looking at me critically. '),
	 (7,1,'7. Are you often haunted by useless thoughts that do not come out of your head, although you try to get rid of them? '),
	 (8,1,'8. I am rather nervous.'),
	 (9,1,'9. It seems to me that no one understands me. '),
	 (10,1,'10. I am rather irritable. ');
INSERT IGNORE INTO emotional_help.questions (id,questionnaires_id,name) VALUES
	 (11,1,'11. If they had not been set against me, my business would have been more successful. '),
	 (12,1,'12. I take trouble too close and for a long time.'),
	 (13,1,'13. Even the thought of a possible failure worries me. '),
	 (14,1,'14. I had very strange and unusual experiences. '),
	 (15,1,'15. Do you sometimes feel happy or sad for no apparent reason? '),
	 (16,1,'16. During the whole day I dream and fantasize more than necessary.'),
	 (17,1,'17. Is it easy to change your mood?'),
	 (18,1,'18. I often fight with myself not to show my shyness. '),
	 (19,1,'19. I would like to be as happy as other people seem to be. '),
	 (20,1,'20. Sometimes I tremble or have chills.');
INSERT IGNORE INTO emotional_help.questions (id,questionnaires_id,name) VALUES
	 (21,1,'21. Does your mood often change, with or without a serious reason? '),
	 (22,1,'22. Do you sometimes experience a feeling of fear even in the absence of real danger?'),
	 (23,1,'23. Criticism or reprimand hurts me a lot.'),
	 (24,1,'24. At times I am so restless that I can not even sit in one place.'),
	 (25,1,'25. Do you sometimes worry too much about small things?'),
	 (26,1,'26. I often feel dissatisfied.'),
	 (27,1,'27. I find it difficult to concentrate when doing any task or work. '),
	 (28,1,'28. I do a lot of things that I have to regret. '),
	 (29,1,'29. For the most part I am happy. '),
	 (30,1,'30. I''m not confident enough. ');
INSERT IGNORE INTO emotional_help.questions (id,questionnaires_id,name) VALUES
	 (31,1,'31. Sometimes I feel really worthless to myself.'),
	 (32,1,'32. Often I just feel bad.'),
	 (33,1,'33. I delve into myself a lot.'),
	 (34,1,'34. I suffer from feelings of inferiority.'),
	 (35,1,'35. Sometimes everything hurts me. '),
	 (36,1,'36. I have a depressing state. '),
	 (37,1,'37. I have something with my nerves.'),
	 (38,1,'38. I find it difficult to keep up a conversation when meeting. '),
	 (39,1,'40. Do you sometimes feel that the difficulties are great and insurmountable? ');
INSERT IGNORE INTO emotional_help.questions (id,questionnaires_id,name) VALUES
	 (40,2,'1. Sadness'),
	 (41,2,'2. Pessimism'),
	 (42,2,'3. Sense of failure'),
	 (43,2,'4. Loss of pleasure'),
	 (44,2,'5. Guilt'),
	 (45,2,'6. Sense of punishment'),
	 (46,2,'7. Loathing'),
	 (47,2,'8. Self-incrimination'),
	 (48,2,'9. Suicidal ideas'),
	 (49,2,'10. Crying');
INSERT IGNORE INTO emotional_help.questions (id,questionnaires_id,name) VALUES
	 (50,2,'11. Irritability'),
	 (51,2,'12. Social withdrawal'),
	 (52,2,'13. Indecision'),
	 (53,2,'14. Feelings of wothlessness'),
	 (54,2,'15. Difficulty of concentration'),
	 (55,2,'16. Change of sleep'),
	 (56,2,'17. Fatigue'),
	 (57,2,'18. Changes in appetite'),
	 (58,2,'19. Weight changes'),
	 (59,2,'20. Health');
INSERT IGNORE INTO emotional_help.questions (id,questionnaires_id,name) VALUES
	 (60,2,'21. Loss of interest in sex');
INSERT IGNORE INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (1,1,'Yes',1),
	 (2,1,'No',0),
	 (3,2,'Yes',1),
	 (4,2,'No',0),
	 (5,3,'Yes',1),
	 (6,3,'No',0),
	 (7,4,'Yes',1),
	 (8,4,'No',0),
	 (9,5,'Yes',1),
	 (10,5,'No',0);
INSERT IGNORE INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (11,6,'Yes',1),
	 (12,6,'No',0),
	 (13,7,'Yes',1),
	 (14,7,'No',0),
	 (15,8,'Yes',1),
	 (16,8,'No',0),
	 (17,9,'Yes',1),
	 (18,9,'No',0),
	 (19,10,'Yes',1),
	 (20,10,'No',0);
INSERT IGNORE INTO emotional_help.answers (id, quetisons_id,name,points) VALUES
	 (21,11,'Yes',1),
	 (22,11,'No',0),
	 (23,12,'Yes',1),
	 (24,12,'No',0),
	 (25,13,'Yes',1),
	 (26,13,'No',0),
	 (27,14,'Yes',1),
	 (28,14,'No',0),
	 (29,15,'Yes',1),
	 (30,15,'No',0);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (31,16,'Yes',1),
	 (32,16,'No',0),
	 (33,17,'Yes',1),
	 (34,17,'No',0),
	 (35,18,'Yes',1),
	 (36,18,'No',0),
	 (37,19,'Yes',1),
	 (38,19,'No',0),
	 (39,20,'Yes',1),
	 (40,20,'No',0);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (41,21,'Yes',1),
	 (42,21,'No',0),
	 (43,22,'Yes',1),
	 (44,22,'No',0),
	 (45,23,'Yes',1),
	 (46,23,'No',0),
	 (47,24,'Yes',1),
	 (48,24,'No',0),
	 (49,25,'Yes',1),
	 (50,25,'No',0);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (51,26,'Yes',1),
	 (52,26,'No',0),
	 (53,27,'Yes',1),
	 (54,27,'No',0),
	 (55,28,'Yes',1),
	 (56,28,'No',0),
	 (57,29,'Yes',1),
	 (58,29,'No',0),
	 (59,30,'Yes',1),
	 (60,30,'No',0);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (61,31,'Yes',1),
	 (62,31,'No',0),
	 (63,32,'Yes',1),
	 (64,32,'No',0),
	 (65,33,'Yes',1),
	 (66,33,'No',0),
	 (67,34,'Yes',1),
	 (68,34,'No',0),
	 (69,35,'Yes',1),
	 (70,35,'No',0);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (71,36,'Yes',1),
	 (72,36,'No',0),
	 (73,37,'Yes',1),
	 (74,37,'No',0),
	 (75,38,'Yes',1),
	 (76,38,'No',0),
	 (77,39,'Yes',1),
	 (78,39,'No',0);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (79,40,'I do not feel sad.',0),
	 (80,40,'I feel sad.',1),
	 (81,40,'I am sad all the time and I can''t snap out of it.',2),
	 (82,40,'I am so sad and unhappy that I can''t stand it.',3),
	 (83,41,'I am not particularly discouraged about the future.',0),
	 (84,41,'I feel discouraged about the future.',1),
	 (85,41,'I feel I have nothing to look forward to.',2),
	 (86,41,'I feel the future is hopeless and that things cannot improve.',3),
	 (87,42,'I do not feel like a failure.',0),
	 (88,42,'I feel I have failed more than the average person.',1);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (89,42,'As I look back on my life, all I can see is a lot of failures.',2),
	 (90,42,'I feel I am a complete failure as a person.',3),
	 (91,43,'I get as much satisfaction out of things as I used to.',0),
	 (92,43,'I don''t enjoy things the way I used to.',1),
	 (93,43,'I don''t get real satisfaction out of anything anymore.',2),
	 (94,43,'I am dissatisfied or bored with everything.',3),
	 (95,44,'I don''t feel particularly guilty.',0),
	 (96,44,'I feel guilty a good part of the time.',2),
	 (97,44,'I feel quite guilty most of the time.',2),
	 (98,44,'I feel guilty all of the time.',3);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (99,45,'I don''t feel I am being punished.',0),
	 (10,45,'I feel I may be punished.',1),
	 (101,45,'I expect to be punished.',2),
	 (102,45,'I feel I am being punished.',3),
	 (103,46,'I don''t feel disappointed in myself.',0),
	 (104,46,'I am disappointed in myself.',1),
	 (105,46,'I am disgusted with myself.',2),
	 (106,46,'I hate myself.',3),
	 (107,47,'I don''t feel I am any worse than anybody else.',0),
	 (108,47,'I am critical of myself for my weaknesses or mistakes.',1);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (109,47,'I blame myself all the time for my faults.',2),
	 (110,47,'I blame myself for everything bad that happens.',3),
	 (111,48,'I don''t have any thoughts of killing myself.',0),
	 (112,48,'I have thoughts of killing myself, but I would not carry them out.',1),
	 (113,48,'I would like to kill myself.',2),
	 (114,48,'I would kill myself if I had the chance.',3),
	 (115,49,'I don''t cry any more than usual.',0),
	 (116,49,'I cry more now than I used to.',1),
	 (117,49,'I cry all the time now.',2),
	 (118,49,'I used to be able to cry, but now I can''t cry even though I want to.',3);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (119,50,'I am no more irritated by things than I ever was.',0),
	 (120,50,'I am slightly more irritated now than usual.',1),
	 (121,50,'I am quite annoyed or irritated a good deal of the time.',3),
	 (122,50,'I feel irritated all the time.',3),
	 (123,51,'I have not lost interest in other people.',0),
	 (124,51,'I am less interested in other people than I used to be.',1),
	 (125,51,'I have lost most of my interest in other people.',2),
	 (126,51,'I have lost all of my interest in other people.',3),
	 (127,52,'I make decisions about as well as I ever could.',0),
	 (128,52,'I put off making decisions more than I used to.',1);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (129,52,'I have greater difficulty in making decisions more than I used to.',2),
	 (130,52,'I can''t make decisions at all anymore.',3),
	 (131,53,'I don''t feel that I look any worse than I used to.',0),
	 (132,53,'I am worried that I am looking old or unattractive.',1),
	 (133,53,'I feel there are permanent changes in my appearance that make me look unattractive.',2),
	 (134,53,'I believe that I look ugly.',3),
	 (135,54,'I can work about as well as before.',0),
	 (136,54,'It takes an extra effort to get started at doing something.',1),
	 (137,54,'I have to push myself very hard to do anything.',2),
	 (138,54,'I can''t do any work at all.',3);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (139,55,'I can sleep as well as usual.',0),
	 (140,55,'I don''t sleep as well as I used to.',1),
	 (141,55,'I wake up 1-2 hours earlier than usual and find it hard to get back to sleep.',2),
	 (142,55,'I wake up several hours earlier than I used to and cannot get back to sleep.',3),
	 (143,56,'I don''t get more tired than usual.',0),
	 (144,56,'I get tired more easily than I used to.',1),
	 (145,56,'I get tired from doing almost anything.',2),
	 (146,56,'I am too tired to do anything.',3),
	 (147,57,'My appetite is no worse than usual.',0),
	 (148,57,'My appetite is not as good as it used to be.',1);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (149,57,'My appetite is much worse now.',2),
	 (150,57,'I have no appetite at all anymore.',3),
	 (151,58,'I haven''t lost much weight, if any, lately.',0),
	 (152,58,'I have lost more than five pounds.',1),
	 (153,58,'I have lost more than ten pounds.',2),
	 (154,58,'I have lost more than fifteen pounds.',3),
	 (155,59,'I am no more worried about my health than usual.',0),
	 (156,59,'I am worried about physical problems like aches, pains, upset stomach, or constipation.',1),
	 (157,59,'I am very worried about physical problems and it''s hard to think of much else.',2),
	 (158,59,'I am so worried about my physical problems that I cannot think of anything else.',3);
INSERT ignore INTO emotional_help.answers (id,quetisons_id,name,points) VALUES
	 (159,60,'I have not noticed any recent change in my interest in sex.',0),
	 (160,60,'I am less interested in sex than I used to be.',1),
	 (161,60,'I have almost no interest in sex.',2),
	 (162,60,'I have lost interest in sex completely.',3);
INSERT ignore INTO emotional_help.results (id,questionnaires_id,points,short_description,full_description) VALUES
	 (1,1,24,'We consider your emotional state to be normal. Keep it up!','We consider your emotional state to be normal. Keep it up!'),
	 (2,1,40,'We suspect that you have a neurosis. It may be advisable to contact a specialist to discuss and resolve this (tel. +1-111-111-1111)','We suspect that you have a neurosis. It may be advisable to contact a specialist to discuss and resolve this (tel. +1-111-111-1111)'),
	 (3,2,13,'We consider your emotional state to be normal. Keep it up!','We consider your emotional state to be normal. Keep it up!'),
	 (4,2,19,'We suspect that you are mildly depressed. We can
  advise to contact a specialist to discuss and resolve this (tel. +1-111-111-1111)','We suspect that you are mildly depressed. We can
  advise to contact a specialist to discuss and resolve this (tel. +1-111-111-1111)'),
	 (5,2,28,'Moderate depression. We recommend that you consult a doctor who will help you overcome it. We can
  advise one of our specialists (tel. +1-111-111-1111)','Moderate depression. We recommend that you consult a doctor who will help you overcome it. We can
  advise one of our specialists (tel. +1-111-111-1111)'),
	 (6,2,63,'Severe depression. You definitely need to see a doctor who will help you overcome it. We can
  advise one of our specialists (tel. +1-111-111-1111)','Severe depression. You definitely need to see a doctor who will help you overcome it. We can
  advise one of our specialists (tel. +1-111-111-1111)');

INSERT ignore INTO emotional_help.projects (id,title,description) VALUES
	 (1,'What we do?','Our company provides a psychological assistance service (consultations with psychologists, trainings and therapy). We have created a brand new website, a tool that will help us help more people and support our clients and as the first step for understanding yourself and your state is to understand what you feel, what emotions you are experiencing and why. It is often difficult for people to identify specific emotions and therefore we want to help them with this first step with the help of an emotion map. With the help of simple psychological questionnaires, we can help define an emotion that will build a personal map of emotions for each of our users. If the user is worried that he feels a certain range of emotions and this interferes with the quality of his life, we will offer him simple tips to cope with emotions or work out his states in more detail using the services of our service.'),
	 (2,'Why trust us?','Our questions and algorithms are unique to us and are built on decades of study in vocational testing. Our algorithms continuously improve with millions of daily data points to give you real-time accuracy. We firmly believe that you own your data, not us. We never sell your personal data to third parties.');

INSERT ignore INTO emotional_help.specialists (id,name,image,info) VALUES
	 (1,'Dr. Michelle Lind','/img/psychologist-1.jpeg','Dr. Michelle Lind supervises new graduates that are working towards their license in social work, and or mental health. She is also the author of the book The Long Arm of PSTD.Michelle Lind holds a Doctor of Health Sciences from Nova Southeastern University, and a Master’s in Social Workfrom Barry University.'),
	 (2,'Dr.Elizabeth Strong','/img/psychologist-2.jpeg','Now in practice for over a decade, Liz is a Licensed Mental Health Counselor in Central Florida, working with individuals and groups in a variety of settings. She uses her training and experience in the field to help those struggling with anxiety, eating disorders, infertility, relationship, and life transition issues. She has served on the board of The Mental Health Counselors of Central Florida, as well as The Eating Disorder Network of Central Florida.'),
	 (3,'Dr.Tonia Cassaday','/img/psychologist-3.jpeg','Tonia Cassaday is a highly qualified mental health professional with nearly twenty-five years of work experience to include being a faculty member, clinical instructor, researcher, and writer at the Medical University of South Carolina.  Ms. Cassaday has directed a mental health/substance abuse crisis stabilization unit and has seven years of experience providing individual, couples, and group psychotherapy to children, adolescents, and adults.'),
	 (4,'Dr.Dawn Brown','/img/psychologist-4.jpeg','Dawn Brown is a Board Certified Nationally Certified Counselor who has been a counselor for 20 years. Her counseling work includes private practice (both face to face and online), psychiatric treatment programs to include inpatient, outpatient, intensive outpatient, and partial hospitalization programs. She is particularly interested in researching, writing, and working with depression, anxiety and trauma patients.');
INSERT ignore INTO emotional_help.articles (id,title,description,full_description,creation_date) VALUES
	 (1,'What````s the difference between stress and anxiety?','There''s a fine line between stress and anxiety. Both are emotional responses, but stress is typically caused by an external trigger. The trigger can be short-term, such as a work deadline or a fight with a loved one or long-term, such as being unable to work, discrimination, or chronic illness. People under stress experience mental and physical symptoms, such as irritability, anger, fatigue, muscle pain, digestive troubles, and difficulty sleeping. Anxiety, on the other hand, is defined by persistent, excessive worries that don''t go away even in the absence of a stressor. Anxiety leads to a nearly identical set of symptoms as stress: insomnia, difficulty concentrating, fatigue, muscle tension, and irritability. Both mild stress and mild anxiety respond well to similar coping mechanisms. Physical activity, a nutritious and varied diet, and good sleep hygiene are a good starting point, but there are other coping mechanisms available...','<p>If your stress or anxiety does not respond to these management techniques, or if you feel that either stress or anxiety are affecting your day-to-day functioning or mood, consider talking to a mental health professional who can help you understand what you are experiencing and provide you additional coping tools. For example, a psychologist can help determine whether you may have an anxiety disorder. Anxiety disorders differ from short-term feelings of anxiety in their severity and in how long they last: The anxiety typically persists for months and negatively affects mood and functioning. Some anxiety disorders, such as agoraphobia (the fear of public or open spaces), may cause the person to avoid enjoyable activities or make it difficult to keep a job.</p><p> According to the latest data from the National Institute of Mental Health, 31% of Americans will experience an anxiety disorder during their lifetimes.</p><p> One of the most common anxiety disorders is generalized anxiety disorder. To identify if someone has generalized anxiety disorder, a clinician will look for symptoms such as excessive, hard-to-control worry occurring most days over six months. The worry may jump from topic to topic. Generalized anxiety disorder is also accompanied by the physical symptoms of anxiety.</p><p> Another type of anxiety disorder is panic disorder, which is marked by sudden attacks of anxiety that may leave a person sweating, dizzy, and gasping for air. Anxiety may also manifest in the form of specific phobias (such as fear of flying) or as social anxiety, which is marked by a pervasive fear of social situations.</p><p> Anxiety disorders can be treated with psychotherapy, medication, or a combination of the two. One of the most widely used therapeutic approaches is cognitive behavioral therapy, which focuses on changing maladaptive thought patterns related to the anxiety. Another potential treatment is exposure therapy, which involves confronting anxiety triggers in a safe, controlled way in order to break the cycle of fear around the trigger.</p>','2022-12-08 13:15:44'),
	 (2,'Coping with COVID-19 stress easier with a dose of humor!','WASHINGTON — Funny memes may help people cope with the stress of the COVID-19 pandemic, making viewers feel calmer and more content, according to research published by the American Psychological Association. Looking at memes about COVID-19 also increased people''s confidence in their ability to deal with the pandemic, according to the study, published in the journal Psychology of Popular Media...','<p>“As the pandemic kept dragging on, it became more and more interesting to me how people were using social media and memes in particular, as a way to think about the pandemic,” said lead author Jessica Gall Myrick, PhD, a professor at Pennsylvania State University. “We found that viewing just three memes can help people cope with the stress of living during a global pandemic.”</p><p>Researchers surveyed 748 people online in December 2020 to determine whether viewing memes would influence their positive emotions, anxiety, information processing and coping surrounding COVID-19. They also sought to determine how memes with different content, subjects and levels of cuteness could affect the participants. Participants ranged from 18 to 88 years old, with an average age of 41.8, and were mostly white (72.2%), female (54.7%) and without a college degree (63.5%).</p><p>The researchers collected hundreds of popular memes from websites like “IMgur” and “IMGflip” and categorized them based on factors such as whether the image featured a human or an animal, if the human or animal was young or old (with young creatures typically judged as cuter) and whether the caption focused on COVID-19 or not. A group of participants reviewed and rated the humor and cuteness of each meme, and the researchers only selected memes for the study that were viewed as equally funny and cute. </p><p>While most of the memes were left unaltered from their source, the researchers wrote some original captions to create similar COVID-related versus non-COVID-related captions for each meme. For example, one meme featured a picture of an angry cat with a COVID-related caption that said, “New study confirms: Cats can''t spread COVID-19 but would if given option.”</p><p> The non-COVID-related version of the meme showed the same cat image with the caption, “New study confirms: Cats can''t sabotage your car but would if given option.” The researchers first measured how often in the past month participants felt nervous or stressed, among other items. The participants were then randomly assigned to view three memes with the same kind of subject (animal or human), cuteness level (adult or baby) and caption (COVID-related or non-COVID-related) or one of three control conditions featuring plain text without any images. After viewing the media, participants rated how cute and funny they found the meme or control text and reported their levels of anxiety and positive emotions such as calmness, relaxation and cheer. They also rated how much the media caused them to think about other information they knew about COVID-19, their confidence in their ability to cope with the pandemic and their stress about the disease.</p><p> The researchers found that people who viewed memes compared with other types of media reported higher levels of humor and more positive emotions, which was indirectly related to a decrease in stress about the COVID-19 pandemic. People who viewed memes with captions related to COVID-19 were even more likely to have lower stress levels about the pandemic than people who viewed memes without COVID-related captions.</p><p> “While the World Health Organization recommended that people avoid too much COVID-related media for the benefit of their mental health, our research reveals that memes about COVID-19 could help people feel more confident in their ability to deal with the pandemic,” Myrick said. “This suggests that not all media are uniformly bad for mental health and people should stop and take stock of what type of media they are consuming. If we are all more conscious of how our behaviors, including time spent scrolling, affect our emotional states, then we will better be able to use social media to help us when we need it and to take a break from it when </p><p>The researchers also found that people who viewed COVID-related memes thought more deeply about the content they viewed and felt more confident in their ability to cope with the pandemic than people who viewed non-COVID-related captions or any of the control conditions. However, people who viewed cute memes featuring human or animal babies were less likely to think about the pandemic and process how it affected their lives, even when the memes'' captions were about COVID-19. </p><p> These findings suggest that social media content about stressful public events can help people process the news without getting overwhelmed by it, according to Myrick. “Public health advocates or government agencies could potentially benefit by using memes as a cheap, easily accessible way to communicate about stressful events with the public, though they should avoid overly cute memes,” Myrick said.</p><p> “The positive emotions associated with this type of content may make people feel psychologically safer and therefore better able to pay attention to the underlying messages related to health threats.” </p>','2022-12-08 13:17:06'),
	 (3,'Types of Depression','It''s normal to feel down once in a while, but if you''re sad most of the time and it affects your daily life, you may have clinical depression. It''s a condition you can treat with medicine, talking to a therapist, and changes to your lifestyle. There are many different types of depression. Events in your life cause some, and chemical changes in your brain cause others. Whatever the cause, your first step is to let your doctor know how you''re feeling. They may refer you to a mental health specialist to help figure out the type of depression you have. This diagnosis is important in deciding the right treatment for you...','<h2>Major Depression</h2><p>You may hear your doctor call this "major depressive disorder." You might have this type if you feel depressed most of the time for most days of the week. </p> <p>Some other symptoms you might have are: </p><ul> <li>Loss of interest or pleasure in your activities</li><li> Weight loss or gain </li><li> Trouble getting to sleep or feeling sleepy during the day</li><li>Feeling restless and agitated, or else very sluggish and slowed down physically or mentally</li><li> Being tired and without energy</li><li> Feeling worthless or guilty</li><li> Trouble concentrating or making decisions</li><li> Thoughts of suicide</li></ul><p> Your doctor might diagnose you with major depression if you have five or more of these symptoms on most days for 2 weeks or longer. At least one of the symptoms must be a depressed mood or loss of interest in activities. </p><p>Major depression looks differently in different people. Depending on how your depression makes you feel, it could be:</p><h3> Anxious distress.</h3><p> You feel tense and restless most days. You have trouble concentrating because you''re worried that something awful could happen, and you feel like you might lose control of yourself. </p><h3> Melancholy. </h3><p>You feel intensely sad and lose interest in the activities you used to enjoy. You feel bad even when good things happen. You might also:</p><ul><li> Feel particularly down in the mornings</li><li>Lose weight</li><li> Sleep poorly</li><li> Have suicidal thoughts</li></ul><p> If you have melancholic depression, your symptoms might be worst in the mornings when you first wake up. Consider having someone help you with your first tasks of the day. Make sure to eat regularly even if you don''t feel hungry.</p><h3>Agitated.</h3><p> You feel uneasy most of the time. You may also:</p> <ul><li>Talk a lot </li><li>Move for no reason, like fidgeting with your hands and pacing around the room </li><li> Act impulsively </li></ul><p>Talk therapy can help. You''ll meet with a mental health specialist who will help you find ways to manage your depression. Medications called antidepressants can also be useful. When therapy and medication aren''t working, other options your doctor may suggest are:</p><ul><li>Electroconvulsive therapy (ECT)</li><li>Transcranial magnetic stimulation (TMS)</li><li>Vagus Nerve Stimulation (VNS)</li></ul><p>ECT uses electrical pulses, TMS uses a special kind of magnet, and VNS uses an implanted device. All are design to stimulate certain areas of brain activity. This helps the parts of your brain that control your mood work better.</p><h2> Persistent Depressive Disorder</h2><p>If you have depression that lasts for 2 years or longer, it''s called persistent depressive disorder. This term is used to describe two conditions previously known as dysthymia (low-grade persistent depression) and chronic major depression.</p><p>You may have symptoms such as:</p><ul><li> Change in your appetite (not eating enough or overeating)</li><li> Sleeping too much or too little</li><li> Lack of energy, or fatigue</li><li> Low self-esteem</li><li> Trouble concentrating or making decisions</li><li>Feeling hopeless</li><p>You may be treated with psychotherapy, medication, or a combination of the two.</p><h2> Bipolar Disorder</h2><p> Someone with bipolar disorder, which is also sometimes called "manic depression," has mood episodes that range from extremes of high energy with an "up" mood to low "depressive" periods.</p><p>When you''re in the low phase, you''ll have the symptoms of major depression.</p><p> Medication can help bring your mood swings under control. Whether you''re in a high or a low period, your doctor may suggest a mood stabilizer, such as lithium.</p><p> The FDA has approved three medicines to treat the depressed phase:</p><ul><li>Seroquel</li><li> Latuda</li><li>Olanzapine-fluoxetine combination</li></ul><p> Doctors sometimes prescribe other drugs "off label" for bipolar depression, such as the anticonvulsant lamotrigine or the atypical antipsychotic Vraylar.</p><p>Traditional antidepressants are not always recommended as first-line treatments for bipolar depression because there''s no proof from studies that these drugs are more helpful than a placebo (a sugar pill) in treating depression in people with bipolar disorder. Also, for a small percentage of people with bipolar disorder, some traditional antidepressants may increase the risk of causing a "high" phase of illness, or speeding up the frequency of having more episodes over time. </p><p> Psychotherapy can also help support you and your family. </p><h2> Seasonal Affective Disorder (SAD)</h2><p> Seasonal affective disorder is a period of major depression that most often happens during the winter months, when the days grow short and you get less and less sunlight. It typically goes away in the spring and summer. If you have SAD, antidepressants can help. So can light therapy. You''ll need to sit in front of a special bright light box for about 15-30 minutes each day.</p><h2> Psychotic Depression</h2><p> People with psychotic depression have the symptoms of major depression along with "psychotic" symptoms, such as:</p><ul><li>Hallucinations (seeing or hearing things that aren''t there)</li><li>Delusions (false beliefs)</li><li>Paranoia (wrongly believing that others are trying to harm you)</li></ul><p> A combination of antidepressant and antipsychotic drugs can treat psychotic depression. ECT may also be an option.</p><h2> Peripartum (Postpartum) Depression</h2><p> Women who have major depression in the weeks and months after childbirth may have peripartum depression. Approximately 1 in 10 men also experience depression in the peripartum period. Antidepressant drugs can help similarly to treating major depression that is unrelated to childbirth. </p><h2> Premenstrual Dysphoric Disorder (PMDD)</h2><p> Women with PMDD have depression and other symptoms at the start of their period. </p><p> Besides feeling depressed, you may also have: </p><ul><li> Mood swings</li><li>Irritability</li><li>Anxiety</li><li>Trouble concentrating</li><li> Fatigue</li><li>Change in appetite or sleep habits</li><li>Feelings of being overwhelmed</li><li> Antidepressant medication or sometimes oral contraceptives can treat PMDD</li></ul><h2> ''Situational'' Depression</h2><p>This isn''t a technical term in psychiatry. But you can have a depressed mood when you''re having trouble managing a stressful event in your life, such as a death in your family, a divorce, or losing your job. Your doctor may call this "stress response syndrome."</p><p> Psychotherapy can often help you get through a period of depression that''s related to a stressful situation. </p><h2>Atypical Depression</h2><p>This type is different from the persistent sadness of typical depression. It is considered to be a "specifier" that describes a pattern of depressive symptoms. If you have atypical depression, a positive event can temporarily improve your mood.Other symptoms of atypical depression include:</p><ul><li> Increased appetite</li><li> Sleeping more than usual</li><li>Feeling of heaviness in your arms and legs</li><li>Oversensitive to criticism</li></ul><p>Antidepressants can help. Your doctor may suggest a type called an SSRI (selective serotonin reuptake inhibitor) as the first-line treatment.They may also sometimes recommend an older type of antidepressant called an MAOI (monoamine oxidase inhibitor), which is a class of antidepressants that has been well-studied in treating atypical depression.</p><h2> Treatment Resistant Depression</h2><p> About 1/3 of people treated for depression try several treatment methods without success. If that''s you, you might have treatment resistant depression. There are many reasons your depression might be treatment resistant. For example, you might have other conditions that make your depression difficult to treat. If you''re diagnosed with treatment resistant depression, your doctor might recommend some less conventional treatment options. Electroconvulsive therapy (ECT) is sometimes helpful in this situation.</p>','2022-12-08 13:19:51'),
	 (4,'Coping with stress at work','Everyone who has ever held a job has, at some point, felt the pressure of work-related stress. Any job can have stressful elements, even if you love what you do. In the short-term, you may experience pressure to meet a deadline or to fulfill a challenging obligation. But when work stress becomes chronic, it can be overwhelming—and harmful to both physical and emotional health...','<p>Unfortunately, such long-term stress is all too common. In fact, APA''s annual Stress in America survey has consistently found that work is cited as a significant source of stress by a majority of Americans. You can''t always avoid the tensions that occur on the job. Yet you can take steps to manage work-related stress.</p><h2>Common sources of work stress</h2><p>Certain factors tend to go hand-in-hand with work-related stress. Some common workplace stressors are:</p><ul><li>Low salaries</li><li>Excessive workloads Few opportunities for growth or advancement</li><li>Work that isn''t engaging or challenging Lack of social support</li><li>Not having enough control over job-related decisions</li><li>Conflicting demands or unclear performance expectations</li></ul><h2>Effects of uncontrolled stress</h2><p>Work-related stress doesn''t just disappear when you head home for the day. When stress persists, it can take a toll on your health and well-being. A stressful work environment can contribute to problems such as headache, stomach-ache, sleep disturbances, short temper, and difficulty concentrating. Chronic stress can result in anxiety, insomnia, high blood pressure, and a weakened immune system. It can also contribute to health conditions such as depression, obesity, and heart disease. Compounding the problem, people who experience excessive stress often deal with it in unhealthy ways, such as overeating, eating unhealthy foods, smoking cigarettes, or abusing drugs and alcohol.</p><h2>Taking steps to manage stress</h2><p>Track your stressors. Keep a journal for a week or two to identify which situations create the most stress and how you respond to them. Record your thoughts, feelings, and information about the environment, including the people and circumstances involved, the physical setting, and how you reacted. Did you raise your voice? Get a snack from the vending machine? Go for a walk? Taking notes can help you find patterns among your stressors and your reactions to them. Develop healthy responses. Instead of attempting to fight stress with fast food or alcohol, do your best to make healthy choices when you feel the tension rise. Exercise is a great stress-buster. Yoga can be an excellent choice, but any form of physical activity is beneficial. Also make time for hobbies and favorite activities. Whether it''s reading a novel, going to concerts, or playing games with your family, make sure to set aside time for the things that bring you pleasure. Getting enough good-quality sleep is also important for effective stress management. Build healthy sleep habits by limiting your caffeine intake late in the day and minimizing stimulating activities, such as computer and television use, at night. Establish boundaries. In today''s digital world, it''s easy to feel pressure to be available 24 hours a day. Establish some work-life boundaries for yourself. That might mean making a rule not to check email from home in the evening, or not answering the phone during dinner. Although people have different preferences when it comes to how much they blend their work and home life, creating some clear boundaries between these realms can reduce the potential for work-life conflict and the stress that goes with it. Take time to recharge. To avoid the negative effects of chronic stress and burnout, we need time to replenish and return to our pre-stress level of functioning. This recovery process requires “switching off” from work by having periods of time when you are neither engaging in work-related activities, nor thinking about work. That''s why it''s critical that you disconnect from time to time, in a way that fits your needs and preferences. Don''t let your vacation days go to waste. When possible, take time off to relax and unwind, so you come back to work feeling reinvigorated and ready to perform at your best. When you''re not able to take time off, get a quick boost by turning off your smartphone and focusing your attention on nonwork activities for a while. Learn how to relax. Techniques such as meditation, deep breathing exercises, and mindfulness (a state in which you actively observe present experiences and thoughts without judging them) can help melt away stress. Start by taking a few minutes each day to focuson a simple activity like breathing, walking, or enjoying a meal. The skill of being able to focus purposefully on a single activity without distraction will get stronger with practice and you''ll find that you can apply it to many different aspects of your life.Talk to your supervisor. Employee health has been linked to productivity at work, so your boss has an incentive to create a work environment that promotes employee well-being. Start by having an open conversation with your supervisor. The purpose of this isn''t to lay out a list of complaints, but rather to come up with an effective plan for managing the stressors you''ve identified, so you can perform at your best on the job. While some parts of the plan may be designed to help you improve your skills in areas such as time management, other elements might include identifying employer-sponsored wellness resources you can tap into, clarifying what''s expected of you, getting necessary resources or support from colleagues, enriching your job to include more challenging or meaningful tasks, or making changes to your physical workspace to make it more comfortable and reduce strain. Get some support. Accepting help from trusted friends and family members can improve your ability to manage stress. Your employer may also have stress management resources available through an employee assistance program, including online information, available counselling, and referral to mental health professionals, if needed. If you continue to feel overwhelmed by work stress, you may want to talk to a psychologist, who can help you better manage stress and change unhealthy behavior.</p>','2022-12-08 13:33:51'),
	 (5,'The 6 Major Theories of Emotion','Emotions exert an incredibly powerful force on human behavior. Strong emotions can cause you to take actions you might not normally perform or to avoid situations you enjoy. Why exactly do we have emotions? What causes them? Researchers, philosophers, and psychologists have proposed various theories of emotion to explain the how and why behind our feelings.','<h2>What Is Emotion?</h2><p>In psychology, emotion is often defined as a complex state of feeling that results in physical and psychological changes that influence thought and behavior. Emotionality is associated with a range of psychological phenomena, including temperament, personality, mood, and motivation. According to author David G. Myers, human emotion involves "...physiological arousal, expressive behaviours, and conscious experience."</p><h2>Types of Theories of Emotion</h2><p>The major theories of emotion can be grouped into three main categories:</p><ul><li> Physiological theories suggest that responses within the body are responsible for emotions.</li><li> Neurological theories propose that activity within the brain leads to emotional responses.</li><li> Cognitive theories argue that thoughts and other mental activity play an essential role in forming emotions.</li></ul><h2>Evolutionary Theory of Emotion</h2><p>Naturalist Charles Darwin proposed that emotions evolved because they were adaptive and allowed humans and animals to survive and reproduce. Feelings of love and affection lead people to seek mates and reproduce. Feelings of fear compel people to fight or flee the source of danger.</p><p>According to the evolutionary theory of emotion, our emotions exist because they serve an adaptive role. Emotions motivate people to respond quickly to stimuli in the environment, which helps improve the chances of success and survival.</p><p>Understanding the emotions of other people and animals also plays a crucial role in safety and survival. If you encounter a hissing, spitting, and clawing animal, chances are you will quickly realize that the animal is frightened or defensive and leave it alone. Being able to interpret correctly the emotional displays of other people and animals allows you to respond correctly and avoid danger.</p><h2>The James-Lange Theory of Emotion</h2><p>The James-Lange theory is one of the best-known examples of a physiological theory of emotion. Independently proposed by psychologist William James and physiologist Carl Lange, the James-Lange theory of emotion suggests that emotions occur as a result of physiological reactions to events.</p><p>According to the James-Lange theory of emotion, an external stimulus leads to a physiological reaction. Your emotional reaction depends upon how you interpret those physical reactions.</p><p>For example, suppose you are walking in the woods and see a grizzly bear. You begin to tremble, and your heart begins to race. The James-Lange theory proposes that you will conclude that you are frightened ("I am trembling. Therefore, I am afraid"). According to this theory of emotion, you are not trembling because you are frightened. Instead, you feel frightened because you are trembling.</p><h2>The Cannon-Bard Theory of Emotion</h2><p>Another well-known physiological theory is the Cannon-Bard theory of emotion. Walter Cannon disagreed with the James-Lange theory of emotion on several different grounds. First, he suggested, people can experience physiological reactions linked to emotions without actually feeling those emotions. For example, your heart might race because you have been exercising, not because you are afraid. Cannon also suggested that emotional responses occur much too quickly to be simply products of physical states. When you encounter a danger in the environment, you will often feel afraid before you start to experience the physical symptoms associated with fear, such as shaking hands, rapid breathing, and a racing heart.</p><p>According to the Cannon-Bard theory of emotion, we feel emotions and experience physiological reactions such as sweating, trembling, and muscle tension simultaneously.</p><p>Cannon first proposed his theory in the 1920s, and his work was later expanded on by physiologist Philip Bard during the 1930s. More specifically, the theory proposes that emotions result when the thalamus sends a message to the brain in response to a stimulus, resulting in a physiological reaction. At the same time, the brain also receives signals triggering the emotional experience. Cannon and Bard''s theory suggests that the physical and psychological experience of emotion happen at the same time and that one does not cause the other.</p><h2>Schachter-Singer Theory</h2><p>Also known as the two-factor theory of emotion, the Schachter-Singer theory is an example of a cognitive theory of emotion. This theory suggests that the physiological arousal occurs first, and then the individual must identify the reason for this arousal to experience and label it as an emotion. A stimulus leads to a physiological response that is then cognitively interpreted and labelled, resulting in an emotion. Schachter and Singer''s theory draws on both the James-Lange theory and the Cannon-Bard theory. Like the James-Lange theory, the Schachter-Singer theory proposes that people infer emotions based on physiological responses. The critical factor is the situation and the cognitive interpretation that people use to label that emotion.</p><p>The Schachter-Singer theory is a cognitive theory of emotion that suggests our thoughts are responsible for emotions.</p><p>Like the Cannon-Bard theory, the Schachter-Singer theory also suggests that similar physiological responses can produce varying emotions. For example, if you experience a racing heart and sweating palms during an important exam, you will probably identify the emotion as anxiety. If you experience the same physical responses on a date, you might interpret those responses as love, affection, or arousal</p><h2>Cognitive Appraisal Theory</h2><p>According to appraisal theories of emotion, thinking must occur first before experiencing emotion. Richard Lazarus was a pioneer in this area of emotion, and this theory is often referred to as the Lazarus theory of emotion.</p><p>The cognitive appraisal theory asserts that your brain first appraises a situation, and the resulting response is an emotion.</p><p>According to this theory, the sequence of events first involves a stimulus, followed by thought, which then leads to the simultaneous experience of a physiological response and the emotion. For example, if you encounter a bear in the woods, you might immediately begin to think that you are in great danger. This then leads to the emotional experience of fear and the physical reactions associated with the fight-or-flight response.</p><h2>Facial-Feedback Theory of Emotion</h2><p>The facial-feedback theory of emotions suggests that facial expressions are connected to experiencing emotions. Charles Darwin and William James both noted early on that, sometimes, physiological responses often have a direct impact on emotion, rather than simply being a consequence of the emotion.</p><p>The facial-feedback theory suggests that emotions are directly tied to changes in facial muscles. For example, people who are forced to smile pleasantly at a social function will have a better time at the event than they would if they had frowned or carried a more neutral facial expression.</p>','2022-12-08 13:35:51');

