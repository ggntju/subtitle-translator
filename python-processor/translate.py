import webvtt
import os
import requests
import json

URL = "http://iloveyou.tplinkdns.com:5000/basic-translator"
# create a folder for translated files if it does not exist
path = os.getcwd() + "/translated"
if(os.path.exists(path) == False):
	try:
		os.mkdir(path)
	except OSError:
		print ("Creation of the directory %s failed" % path)
	else:
		print ("Successfully created the directory %s " % path)

def write2File(fileName, JSONObject):
	j = json.loads(JSONObject)
	write2FileName = os.path.splitext(fileName)[0] + "_translated.vtt"
	file = open(path + "/" + write2FileName, mode='a', encoding='utf-8')
	file.write(str(j["id"]) + "\n")
	file.write(j["start"] + " --> " + j["end"] + "\n")
	file.write(j["text"] + "\n")
	file.write("\n")
	file.close()


def translate(fileName, URL):
	counter = 0
	write2FileName = os.path.splitext(fileName)[0] + "_translated.vtt"
	file = open(path + "/" + write2FileName, mode='a', encoding='utf-8')
	file.write("WEBVTT" + "\n")
	file.write("\n")
	file.close()
	for caption in webvtt.read(fileName):
		counter = counter + 1
		PARAMS = {'content': caption.text}
		response = requests.get(url = URL, params = PARAMS)
		response.encoding = 'utf-8'
		JSONString = {
		"id": counter, 
		"start": caption.start,
		"end": caption.end,
		"text": response.text
		}
		JSONObject = json.dumps(JSONString)
		write2File(fileName, JSONObject)

for fileName in os.listdir(os.getcwd()):
	if fileName.endswith(".vtt"):
		print(fileName + " started")
		translate(fileName, URL)
		print(fileName + " completed")
print("All completed")

