
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
	 (1,'What``s the difference between stress and anxiety?','There''s a fine line between stress and anxiety. Both are emotional responses, but stress is typically caused by an external trigger. The trigger can be short-term, such as a work deadline or a fight with a loved one or long-term, such as being unable to work, discrimination, or chronic illness. People under stress experience mental and physical symptoms, such as irritability, anger, fatigue, muscle pain, digestive troubles, and difficulty sleeping. Anxiety, on the other hand, is defined by persistent, excessive worries that don''t go away even in the absence of a stressor. Anxiety leads to a nearly identical set of symptoms as stress: insomnia, difficulty concentrating, fatigue, muscle tension, and irritability. Both mild stress and mild anxiety respond well to similar coping mechanisms. Physical activity,','<p>If your stress or anxiety does not respond to these management techniques, or if you feel that either stress or anxiety are affecting your day-to-day functioning or mood, consider talking to a mental health professional who can help you understand what you are experiencing and provide you additional coping tools. For example, a psychologist can help determine whether you may have an anxiety disorder. Anxiety disorders differ from short-term feelings of anxiety in their severity and in how long they last: The anxiety typically persists for months and negatively affects mood and functioning. Some anxiety disorders, such as agoraphobia (the fear of public or open spaces), may cause the person to avoid enjoyable activities or make it difficult to keep a job.</p>','2022-12-08 13:15:44'),
	 (2,'Coping with COVID-19 stress easier with a dose of humor!','WASHINGTON — Funny memes may help people cope with the stress of the COVID-19 pandemic, making viewers feel calmer and more content, according to research published by the American Psychological Association. Looking at memes about COVID-19 also increased people''s confidence in their ability to deal with the pandemic, according to the study, published in the journal Psychology of Popular Media...','<p>“As the pandemic kept dragging on, it became more and more interesting to me how people were using social media and memes in particular, as a way to think about the pandemic,” said lead author Jessica Gall Myrick, PhD, a professor at Pennsylvania State University. “We found that viewing just three memes can help people cope with the stress of living during a global pandemic.”</p>','2022-12-08 13:17:06'),
	 (3,'Types of Depression','It''s normal to feel down once in a while, but if you''re sad most of the time and it affects your daily life, you may have clinical depression. It''s a condition you can treat with medicine, talking to a therapist, and changes to your lifestyle. There are many different types of depression. Events in your life cause some, and chemical changes in your brain cause others. Whatever the cause, your first step is to let your doctor know how you''re feeling. They may refer you to a mental health specialist to help figure out the type of depression you have. This diagnosis is important in deciding the right treatment for you...','<h2>Major Depression</h2>','2022-12-08 13:19:51'),
	 (4,'Coping with stress at work','Everyone who has ever held a job has, at some point, felt the pressure of work-related stress. Any job can have stressful elements, even if you love what you do. In the short-term, you may experience pressure to meet a deadline or to fulfill a challenging obligation. But when work stress becomes chronic, it can be overwhelming—and harmful to both physical and emotional health...','<p>Unfortunately, such long-term stress is all too common. In fact, APA''s annual Stress in America survey has consistently found that work is cited as a significant source of stress by a majority of Americans. You can''t always avoid the tensions that occur on the job. Yet you can take steps to manage work-related stress.</p>','2022-12-08 13:33:51'),
	 (5,'The 6 Major Theories of Emotion','Emotions exert an incredibly powerful force on human behavior. Strong emotions can cause you to take actions you might not normally perform or to avoid situations you enjoy. Why exactly do we have emotions? What causes them? Researchers, philosophers, and psychologists have proposed various theories of emotion to explain the how and why behind our feelings.','<h2>What Is Emotion?</h2>','2022-12-08 13:35:51');
