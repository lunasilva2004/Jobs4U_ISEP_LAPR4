# Explaining Criteria

--------

1. **Address Management in Job Openings for Diverse Customer Entities:** 

   - In the Domain Model, both the Customer and Job Opening have an associated address. This design choice reflects the 
   real-world scenario where a Customer entity, such as Sonae, might encompass multiple subsidiaries or companies, each 
   with its own distinct location. For instance, Sonae, as the Customer entity, may have various subsidiaries like 
   Continente, Worten, and others. Each subsidiary operates independently and may have its own set of job openings with 
   unique requirements and locations. When creating a Job Opening for a specific subsidiary (e.g., Continente), it's 
   essential to capture the subsidiary's address accurately to ensure that job applicants have clear information about the 
   job location. This address associated with the Job Opening is distinct from the address associated with the Customer 
   entity (Sonae). By incorporating addresses at both the Customer and Job Opening level, the system accommodates the 
   diverse organizational structure of Customers, facilitating effective communication with applicants and ensuring 
   transparency in the recruitment process.
   
   - In addition to the previous explanation, it's important to note the direct relationship between the Job Opening entity
   and its associated address. Unlike the address associated with the Company entity within the Job Opening aggregate, which
   typically represents the company's headquarters or main office location, the address linked directly to the Job Opening 
   entity corresponds specifically to the job's physical work location. For example, consider a scenario where a Customer 
   entity, such as Sonae, operates multiple subsidiaries, including Continente. While the headquarters of Continente may be
   in Lisbon, a Job Opening for a position in a Continente store located in Maia would require a distinct address reflecting 
   the specific work location in Maia. This direct linkage ensures that job applicants receive accurate information about 
   the job's location, facilitating their decision-making process and promoting transparency in the recruitment process. By 
   maintaining separate addresses at both the Customer and Job Opening levels, the system effectively manages the diverse 
   organizational structure of Customers while providing precise location details for each job opportunity. This approach 
   enhances the user experience for both applicants and recruiters, aligning with the system's goal of efficient and 
   transparent recruitment processes.

---------

2. **Distinction between Rank and Grade:** In the context of the application process, it's crucial to distinguish 
between "Rank" and "Grade" as separate concepts. 

   - **Rank:** The rank pertains to the overall assessment or positioning of a candidate relative to others in the 
   application pool for a specific Job Opening. It considers various factors such as qualifications, experiences, and 
   performance in interviews, among others. The rank provides a comparative measure of candidates' suitability for the 
   position.
   
   - **Grade:** On the other hand, the grade specifically refers to the evaluation or score assigned to a candidate 
   based on their performance in an interview. It reflects how well the candidate performed during the interview process, 
   considering factors such as communication skills, technical proficiency, and cultural fit.

   - Importantly, the grade obtained from interviews contributes to determining the rank of a candidate's application for a 
   particular job opening. The higher the grade received in interviews, the more favorable the candidate's position in the 
   overall ranking of applications. Therefore, while the grade focuses on individual performance in interviews, the rank 
   considers this grade along with other criteria to assess candidates' competitiveness in the application process.

--------

3. **Flexible CV Submission within Applications:** 

   - In our Domain Model, each Application contains a Curriculum Vitae (CV), providing candidates with the flexibility to 
   tailor their resumes to specific Job Openings. Placing the CV within the Application entity allows candidates to customize 
   their submissions, emphasizing relevant skills and experiences for each position. This approach streamlines the recruitment 
   process, empowering candidates to present themselves effectively while facilitating efficient application management for 
   recruiters.

--------

4. **Cardinality of Candidate-Interview and Interview-Job Application Associations:** 

   - In our Domain Model, the cardinality between Candidate-Interview and Interview-Job Application associations is set to 
   allow flexibility in the recruitment process. Not every candidate may undergo an interview for every job application they 
   submit. By permitting a one-to-many relationship between Candidate and Interview, candidates can participate in multiple 
   interviews across different job openings, if necessary. Similarly, the one-to-many association between Interview and Job 
   Application acknowledges that not all applications may involve interviews. This flexibility caters to varying recruitment 
   scenarios, ensuring that the system accommodates both interview-based and non-interview-based selection processes.

--------

5. **Cardinality between Job Opening and Function:** 

   - The cardinality of 1..* in the association between Job Opening and Function reflects the scenario where a job opening 
   may require candidates to fulfill multiple functions. This design choice allows for greater flexibility in job descriptions 
   and aligns with real-world business needs where a single position may encompass various roles or responsibilities. For 
   example, consider a retail company like Amazon. They might create a job opening for a "Warehouse Associate" position. 
   In this case, the job opening could specify multiple functions such as picking, packing, and shipping orders. Each 
   function represents a distinct aspect of the job role, and candidates applying for this position must be capable of 
   performing all these functions. By setting the cardinality to 1..*, the system can accommodate job openings with diverse 
   functional requirements, ensuring that candidates possess the necessary skills and competencies to fulfill the job role 
   effectively.

--------

6. **Cardinality in the Association between Phase and Job Opening:**

   - The cardinality of 4..5 in the association between Phase and Job Opening reflects the total number of phases involved 
   in the job opening process. We've identified five distinct phases: application, screening, interviews (which can be optional), 
   analysis, and result. By setting the cardinality to 4..5, we ensure that each job opening can encompass all five phases or 
   as few as four, depending on whether interviews are included. This approach provides flexibility in tailoring the job 
   opening process to specific requirements while accommodating variations in the recruitment workflow.

--------

7. **Positioning of Ranking in the Domain Model:** 

   - We've chosen to place the ranking attribute within the Rank aggregate in our domain model. This decision stems from 
   the understanding that the ranking is determined during one of the final stages of the job opening process. By associating 
   the ranking directly with the Rank entity, it ensures that this attribute gets filled out once all phases of the job opening 
   are completed. This organization allows for the applications with better ratings to be positioned higher in the ranking, 
   providing a clear indication of their standing in relation to other applicants. Additionally, this implementation helps 
   us understand that each job opening has a rank. This rank, in turn, has a list of orders, and each of these orders in 
   the list is related to a job application.

--------

8. **Cardinality between Job Application and File:**

   - The design choice of a cardinality of 1 in the association between Job Application and File allows for the attachment 
of one file processed by the applications email bot that contains a path to the exact folder that contains the files when candidates submit their job applications via email. These 
path can encompass various components, including the content of the email, the attachments within the email, files containing
the contents of each attachment, and a file containing the application data and candidate details. This design enables 
candidates to provide a comprehensive set of documents, such as CVs, cover letters, certificates, or portfolios, directly 
through email. This flexibility enhances the application experience for candidates and facilitates recruiters in evaluating 
applicants based on the wealth of information provided through the application process.

--------

9. **Positioning of Plugin in the Domain Model:**

    - The Plugin entity is not explicitly represented in the provided domain model. However, the InterviewModel and RequirementModel 
   entities could be considered as plugins that extend the system's functionality. By incorporating these entities, the system 
   can support various features, such as Job Requirement Specifications and Interview Models, which enhance the recruitment process.

--------

10. **Positioning of Requirement Specification in the Domain Model:**

    - The inclusion of the Requirement Specification entity within the domain model underscores its fundamental role in 
    defining the criteria and qualifications essential for job openings. Requirement Specifications encapsulate crucial 
    details such as skills, experiences, educational qualifications, and other prerequisites that candidates must fulfill
    to be considered for a job. By associating Requirement Specifications with Job Openings, the system ensures alignment 
    between each job opening and specific requirements, thereby facilitating the recruitment process and enabling the selection 
    of suitable candidates. The Requirement Specification entity serves as an aggregate within this domain model due to its 
    central role in guiding the recruitment workflow. It allows Customer Managers to effectively define and manage the criteria 
    for job openings. This design choice enhances the system's functionality by providing a structured approach to specifying 
    job requirements, thus streamlining the candidate selection process. Additionally, the aggregate nature of Requirement 
    Specification allows for cohesive management of related data and ensures integrity and consistency within the domain model.

--------

11. **Direction of the association Job Opening - Candidate**

    - The association between Job Opening and Candidate is unidirectional, with the Job Opening entity referencing the 
    Candidate entity. This design choice reflects the system's focus on job openings as the primary entities, with candidates 
    being associated with specific job opportunities. By establishing a unidirectional relationship, the system emphasizes the 
    connection between candidates and job openings, enabling efficient management of applications and candidate data within 
    the recruitment process. This design ensures that each job opening can maintain a list of associated candidates, facilitating 
    the evaluation and selection of applicants for the respective positions. The unidirectional association streamlines the 
    process of tracking candidate applications and interactions with job openings, enhancing the system's usability and 
    performance in managing recruitment activities.

--------

12. **Absence of Curriculum Vitae:**

    - Instead of representing the Curriculum Vitae (CV) as a separate value object, it was chosen to treat it as part of the 
    file processing flow (Applications File Bot aggregate). When candidates send their CVs via email, these files are processed 
    by the Application Email Bot to extract relevant information and integrate it into their applications.

--------

13. **Direction of the association Job Opening - Job Application:**
    
    - The association between Job Opening and Job Application is unidirectional, with the Job Opening entity referencing the 
    Job Application entity. This design choice reflects the system's focus on job openings as the primary entities, with job 
    applications being associated with specific job opportunities. By establishing a unidirectional relationship, the system  
    emphasizes the connection between job openings and applications, enabling efficient management of applications within the 
    recruitment process. This design ensures that each job opening can maintain a list of associated applications, facilitating 
    the evaluation and selection of candidates for the respective positions. The unidirectional association streamlines the 
    process of tracking job applications and interactions with job openings, enhancing the system's usability and performance 
    in managing recruitment activities.

--------

14. **Absence of Explicit Interview Entity:**

    - There is no explicit Interview entity. Instead, the interview process is represented through the value object FileJobApp 
    within the Job Application entity and the InterviewGrade. After the application is submitted, the candidates are interviewed, 
    and then the Customer Manager can later upload interview-related files. These files are processed and evaluated by the Manager, 
    resulting in an InterviewGrade being assigned to the Job Application. This design choice reflects the system's focus on the 
    outcomes of the interview process (i.e., the InterviewGrade) rather than the process itself. By structuring the model in 
    this way, the system can efficiently manage and evaluate interview data within the context of each job application, enhancing 
    the recruitment process's overall efficiency and effectiveness.
    
--------

15. **Abstence of Explicit Requirement Entity:**

    - In the provided domain model, there is no explicit Requirement entity. Instead, the system captures job requirements 
    through the FileJobApp value object within the Job Application entity during the screening phase of the job opening. 
    The operator uploads these requirement documents to the system. These documents are then processed and evaluated by the 
    system using a specific grammar. The outcome of this verification is stored in the VerificationResult class associated 
    with the FileJobApp. This design choice reflects the system's focus on the outcomes of the requirement verification process 
    (i.e., the VerificationResult) rather than the process itself. By structuring the model in this way, the system can efficiently 
    manage and evaluate requirement data within the context of each job application, enhancing the recruitment process's 
    overall efficiency and effectiveness.

------

16. **Separation of the rank from the aggregated job application**

    - The separation of the Rank from the JobApplication aggregate in the updated domain model is a strategic decision aimed at 
    improving the design and functionality of the system. By adhering to the Single Responsibility Principle (SRP), we ensure that 
    each aggregate has a focused responsibility. In the previous model, the JobApplication entity managed both application details
    and ranking, which could lead to a more complex and harder-to-maintain codebase. By separating the Rank into its own aggregate,
    the JobApplication aggregate now exclusively handles the details of the application itself, while the Rank aggregate is responsible
    for the ranking logic and data.

    - Each aggregate can be developed, maintained, and modified independently, reducing the risk of changes in one area affecting
    the other. If the ranking logic needs to evolve or scale independently from the job applications, the new model supports such 
    changes more efficiently without complicating the JobApplication logic.

    - Optimizing persistence and performance is another significant benefit. In the old model, persisting and retrieving the 
    JobApplication entity with embedded ranking information could lead to inefficient database operations, especially with frequent
    updates or queries to the ranking data. With the Rank as a separate aggregate, database operations can be optimized for ranking
    data independently, resulting in better performance without impacting the JobApplication data.

    - Furthermore, separating these aggregates brings clarity to the domain model. The new structure accurately reflects real-world
    concepts and processes, making the system easier to understand and work with. By defining the Rank as a distinct aggregate, the
    domain model aligns more closely with domain-driven design (DDD) principles, enhancing the overall architecture's robustness
    and adaptability. 

--------

17. **Association between JobApplication and Rank**

    - The JobApplication is associated with a Rank, which is a separate aggregate in the domain model. The Rank aggregate is 
    responsible for the ranking logic and data, and each Rank has a list of Orders, each of which is related to a Job Application. 
    This association and its implications could be further elaborated.

--------
