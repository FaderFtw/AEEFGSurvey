import requests
import time
import json

# URL of the API
url = "http://localhost:8080/api/survey"

with open("survey_answers.json", "r", encoding="utf-8") as f:
    survey_answers = json.load(f)

# Shuffle the data 
# import random
# random.shuffle(survey_answers[1:])

# with open(f"survey_answers_{time.time()}.json", "w", encoding="utf-8") as f:
#     json.dump(survey_answers, f, indent=4)
# print(survey_answers[0])

# education_mapping = {
#     "Primaire": "6ème",
#     "Primary": "6th",
#     "ابتدائي": "سادسة",
#     "Collège": "7ème",
#     "Middle School": "7th",
#     "الإعدادية": "السابعة",
#     "Secondaire": "1ème",
#     "Secondary": "1st",
#     "ثانوي": "أولى",
#     "Université": "Licence",
#     "University": "Bachelor's",
#     "جامعة": "الإجازة"
# }

# for answer in survey_answers:
#     education = answer.get("education", "").strip()
#     if not answer.get("educationLevel"):
#         answer["educationLevel"] = education_mapping.get(education, "Unknown")

# Save the JSON file with UTF-8 encoding and without escaping characters
# filename = "survey_answers.json"
# with open(filename, "w", encoding="utf-8") as f:
#     json.dump(survey_answers, f, ensure_ascii=False, indent=4)
        

print(len(survey_answers))
questions_responses={}
headers = {'Content-Type': 'application/json; charset=UTF-8'}
for i, answer in enumerate(survey_answers):
    response = requests.post(url,headers=headers, data=json.dumps(answer))
    if response.status_code == 200:
        print(f"Successfully sent Answer N°: {i+1}")
    else:
        print(f"Failed to send | Status: {response.status_code} | Error: {response.text}")

    # Wait for 10 seconds
    # time.sleep(3)
    
    # user_input = input("Continue ?: ")
    # if user_input != 'yes':
    #   break
    