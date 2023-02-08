UPDATE ALGORITHM_RULE_CODE SET LABEL='Adult Career Preparation Courses', DESCRIPTION='Excludes Career Preparation (e.g., course code starts with CP) courses where session date > 200009 from meeting any Requirement Type on the 1950 program. Exception: does not exclude CPWE 12'
WHERE ALGORITHM_RULE_CODE='ADULT_CP_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Adult student must be in grade AD', DESCRIPTION='Checks if student is in grade AD (student on the Adult Graduation Program who is expected to graduate this year)'
WHERE ALGORITHM_RULE_CODE='ADULT_SG_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Adult Work Experience', DESCRIPTION='If student is graduating prior to 201409, limits the number of work experience courses that can be used to meet any Requirement Type on the 1950 program. Work experience courses are identified under rule #506.'
WHERE ALGORITHM_RULE_CODE='ADULT_WRK_EXP_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='DD - Assessments Match Credits', DESCRIPTION='Checks if a student enrolled in Programme francophone has met Assessment requirements (in English) for the B.C. Certificate of Graduation (English - Dual Dogwood)'
WHERE ALGORITHM_RULE_CODE='ASSMT_DD_MATCH_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='FI - Assessments Match Credits', DESCRIPTION='Checks if student has met Assessment requirements for the French Immersion program (i.e., those listed under the applicable rule number)'
WHERE ALGORITHM_RULE_CODE='ASSMT_FI_MATCH_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Assessments Match Credits', DESCRIPTION='Checks if student has met Assessment requirements for their main program (i.e., those listed under the applicable rule number)'
WHERE ALGORITHM_RULE_CODE='ASSMT_MATCH_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Assessment Registrations', DESCRIPTION='Checks if the assessment date is current or future dated (e.g., from today YYYYMM) or later) and no final result or special case exists'
WHERE ALGORITHM_RULE_CODE='ASSMT_REGISTRATION_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Board/Authority Authorized Courses', DESCRIPTION='Excludes Board/Authority Authorized (e.g., course code starts with Y) courses from meeting any Requirement Type on the 1950 program'
WHERE ALGORITHM_RULE_CODE='BAA_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Career Preparation Courses', DESCRIPTION='Excludes Career Preparation (e.g., course code starts with CP) courses from meeting any Requirement Type on the 2004 or 2018 program'
WHERE ALGORITHM_RULE_CODE='CP_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='CP - Match Credits', DESCRIPTION='Checks if a student earned a minimum of 3 credits in an eligible work experience course'
WHERE ALGORITHM_RULE_CODE='CP_MATCH_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Course Registrations', DESCRIPTION='Checks if the course session date is current or future dated (e.g., from today YYYYMM) or later) and no final result or special case exists'
WHERE ALGORITHM_RULE_CODE='CRSE_REGISTRATION_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='DD - Match Credits', DESCRIPTION='Checks if a student enrolled in Programme francophone earned a minimum of 4-credits in one or more eligible courses (in English) for a required subject area (i.e., courses listed under the applicable Rule #) for the B.C. Certificate of Graduation (English - Dual Dogwood)'
WHERE ALGORITHM_RULE_CODE='DD_MATCH_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Duplicate Assessments', DESCRIPTION='If duplicate assessment code, uses the assessment with the highest proficiency score, then special case (AEG, or Exempt/MET), then earliest session.'
WHERE ALGORITHM_RULE_CODE='DUPLICATE_ASSMT_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Duplicate Courses', DESCRIPTION='If duplicate course code and course level is found, uses the course with the highest number of credits, then highest final %, then earliest session date'
WHERE ALGORITHM_RULE_CODE='DUPLICATE_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Assessment Equivalency', DESCRIPTION='Checks for eligible, successfully completed courses with a written provincial exam to meet a Graduation Assessment requirement'
WHERE ALGORITHM_RULE_CODE='EQUIVALENCY_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Excluded courses after Program Expiry Date', DESCRIPTION='If course session date is after the Program Expiry Date (e.g., graduation program closed date), excludes the course from the graduation algorithm'
WHERE ALGORITHM_RULE_CODE='EXCL_AFT_PRG_CUTOFF_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Exclude grade 10 courses', DESCRIPTION='Excludes Grade level 10 courses from meeting any Requirement Type on the 1995 program'
WHERE ALGORITHM_RULE_CODE='EXCL_GR10_COURSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Exclude Courses less than 4 credits', DESCRIPTION='Excludes courses with less than 4 credits from meeting any Requirement Type on the 1986 program'
WHERE ALGORITHM_RULE_CODE='EXCL_LESS_4CREDIT_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Exclude Validation Courses', DESCRIPTION='Excludes Validation exams (written in 2005/06 for SS 11, SCH 11, FNS 12 and are not eligible for 1995 grad program)'
WHERE ALGORITHM_RULE_CODE='EXCL_VLDTN_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Failed Assessments', DESCRIPTION='Checks Assessment Special case codes table to determine whether a special case is not considered a successful completion'
WHERE ALGORITHM_RULE_CODE='FAILED_ASSMT_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Failed Courses', DESCRIPTION='Checks letter grade table to determine whether a letter grade or special case is not considered a successful completion'
WHERE ALGORITHM_RULE_CODE='FAILED_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='FI - Match Credits', DESCRIPTION='Checks if student earned a minimum of 4-credits in one or more eligible courses for a required French Immersion subject area (i.e., courses listed under the applicable Rule #)'
WHERE ALGORITHM_RULE_CODE='FI_MATCH_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='FI - Minimum elective credits French Courses', DESCRIPTION='Checks if student earned a minimum of 4 elective credits from courses taught in French (any level)'
WHERE ALGORITHM_RULE_CODE='FI_MIN_ELC_CREDITS_1986_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='FI - Minimum elective credits French Courses', DESCRIPTION='Checks if student earned a minimum of 4 elective credits from courses taught in French at the grade 11 or 12 level'
WHERE ALGORITHM_RULE_CODE='FI_MIN_ELC_CREDITS_1996_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='FI - Minimum Elective Credits', DESCRIPTION='Checks if student earned a minimum of 12 elective credits from courses taught in French, and if 4 of these credits are at the grade 11 or 12 level'
WHERE ALGORITHM_RULE_CODE='FI_MIN_ELECTIVE_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Independent Directed Studies Courses', DESCRIPTION='Excludes Independent Directed Studies (e.g., course code starts with IDS) courses from meeting any Requirement Type on the 1950 program'
WHERE ALGORITHM_RULE_CODE='IDS_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Incomplete Assessments', DESCRIPTION='Checks if the assessment session date has passed (e.g., earlier than today - YYYMM) and no final result or special case exists'
WHERE ALGORITHM_RULE_CODE='INCOMPLETE_ASSMT_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Incomplete Courses', DESCRIPTION='Checks if the course session date has passed (e.g., earlier than today - YYYYMM) and no final result or special case exists.'
WHERE ALGORITHM_RULE_CODE='INCOMPLETE_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Locally Developed Courses', DESCRIPTION='Excludes Locally Developed (e.g., course code starts with X) courses from meeting any Requirement Type on the 1950 program'
WHERE ALGORITHM_RULE_CODE='LD_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='All Requirements Met', DESCRIPTION='Checks if all associated requirements for a main program are met or not met and determines the program completion status'
WHERE ALGORITHM_RULE_CODE='MAIN_PRGM_COMPLETE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Match 4 Credits Courses', DESCRIPTION='Checks if student completed an eligible course (minimum 4-credits per course) for a required subject area (i.e., a course listed under the applicable Rule #)'
WHERE ALGORITHM_RULE_CODE='MATCH_CREDITS_1986_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Match 4 and 2 Credits Courses', DESCRIPTION='Checks if student earned a minimum of 4-credits in one or more eligible, 4 or 2 credit courses for a required subject area (i.e., courses listed under the applicable Rule #)'
WHERE ALGORITHM_RULE_CODE='MATCH_CREDITS_1996_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Match Credits', DESCRIPTION='Checks if student earned a minimum of 4-credits in one or more eligible courses for a required subject area (i.e., courses listed under the applicable Rule #)'
WHERE ALGORITHM_RULE_CODE='MATCH_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Min Adult Courses', DESCRIPTION='Checks if the student has completed at least three out of the five courses required for the Adult Dogwood were completed after the date the student entered the program'
WHERE ALGORITHM_RULE_CODE='MIN_ADULT_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Min Credits', DESCRIPTION='Checks if student completed a minimum of four Ministry courses (minimum 16 credits total) at the grade 12 level'
WHERE ALGORITHM_RULE_CODE='MIN_CREDITS_1986_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Min Credits', DESCRIPTION='Checks if student earned a minimum of 10 elective credits in a grade 12 level Ministry, Career Program or External course'
WHERE ALGORITHM_RULE_CODE='MIN_CREDITS_1996_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Minimum 12 Elective Credits-Final 4 Credits', DESCRIPTION='Checks if student has met a minimum of 12 Elective Credits, and that a minimum of 4 of these credits were earned at the Grade 12 level or in the Social Studies 11 subject area'
WHERE ALGORITHM_RULE_CODE='MIN_CREDITS_ELECTIVE_12_OTHER_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Minimum Credits', DESCRIPTION='Checks if student earned a minimum of 16 credits (of the 80 total credits needed for graduation) in eligible courses at the Grade 12 level'
WHERE ALGORITHM_RULE_CODE='MIN_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Minimum 12 Elective Credits-First 8 Credits', DESCRIPTION='Checks if student has met a minimum of 12 Elective Credits, and that a minimum of 8 of these credits were earned at the Grade 12 level'
WHERE ALGORITHM_RULE_CODE='MIN_CREDTIS_ELECTIVE_12_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Min Elective Credits', DESCRIPTION='Checks if student completed a minimum of 7 courses (minimum 4-credit courses each, 28 credits) at a grade 11 or 12 level'
WHERE ALGORITHM_RULE_CODE='MIN_ELC_CREDITS_1986_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Minimum Elective Credits', DESCRIPTION='Checks if student earned a minimum of 24 elective credits at a grade 11 or 12 level (note: only 8 credits may come from Locally Developed Courses)'
WHERE ALGORITHM_RULE_CODE='MIN_ELC_CREDITS_1996_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='FI - Minimum Elective Credits', DESCRIPTION='Checks if student earned a minimum of 4 elective credits from courses taught in French at the grade 11 or 12 level'
WHERE ALGORITHM_RULE_CODE='MIN_ELC_CREDITS_FRENCH_1996_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Minimum Elective Credits', DESCRIPTION='Checks if student earned a minimum of 28 elective credits'
WHERE ALGORITHM_RULE_CODE='MIN_ELECTIVE_CREDITS_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='No Rule for School Reported Optional Programs', DESCRIPTION='Identifies school reported Optional Programs where the only requirement is that the school has reported student participation in an optional program'
WHERE ALGORITHM_RULE_CODE='OPTIONAL_PROGRAM_NO_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Program Completion Date', DESCRIPTION='Requirement for a student to complete SCCP'
WHERE ALGORITHM_RULE_CODE='PRG_COMP_DATE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Registration Duplicate Assessment', DESCRIPTION='Checks if there are duplicate in progress assessments (i.e. same assessment code)'
WHERE ALGORITHM_RULE_CODE='REGTN_DUPLICATE_ASSMT_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Registration Duplicate Course', DESCRIPTION='Checks if there are duplicate in progress courses (i.e., same course code and course level)'
WHERE ALGORITHM_RULE_CODE='REGTN_DUPLICATE_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Registration Failed Course', DESCRIPTION='Checks letter grade table to determine when an interim letter grade or special case is not considered a successful completion'
WHERE ALGORITHM_RULE_CODE='REGTN_FAILED_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Remove 2-Credit Courses', DESCRIPTION='Excludes courses with less than 4 credits from meeting any Requirement Type on the 1950 program'
WHERE ALGORITHM_RULE_CODE='REMVE_2CREDIT_CRSE_RULE';
UPDATE ALGORITHM_RULE_CODE SET LABEL='Restricted Courses', DESCRIPTION='If a course is restricted against another course, uses the course with the highest number of credits, then highest final %, then earliest session date'
WHERE ALGORITHM_RULE_CODE='RESTRICTED_CRSE_RULE';
