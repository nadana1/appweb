from selenium import webdriver

url = 'https://www.businessnews.com.tn/dernieres-news'

driver = webdriver.Chrome(r"C:\Users\fatma\AppData\Local\Google\Chrome\Application\chromedriver.exe")
driver.get(url)
body = driver.find_element_by_tag_name('body')

fr = [] 

wanted = ['2022', 'steg', 'up']
for word in wanted:
    freq = body.text.lower().count(word) # .lower() to account for count's case sensitive behaviour
    dic = {'phrase': word, 'frequency': freq}
    fr.append(dic)
    print('Frequency of', word, 'is:', freq)