#妲己：512*528  156*156
#娜可露露：156*156
#蓝方防御塔128*128
#红方防御塔：128*128
# 1
import pygame
from pygame.locals import *
import math
import random

# 2
pygame.init()
width,height = 1280,720
screen=pygame.display.set_mode((width,height))
keys = [False, False, False, False]
#Hero_Blue_pos=[30,30]
Hero_Blue_pos=[130,130]
acc=[0,0]
arrows=[]
badtimer=100
badtimer1=0
badguys=[[640,100]]
healthvalue=194
pygame.mixer.init()

# 3 加载图片
#Blue_player = pygame.image.load("image/xiaodaji.png")
bg_haidu = pygame.image.load("image/bg_haidu.jpg")
Hero_Blue_ = pygame.image.load("image/Hero_Blue_.png")
Hero_Red_ = pygame.image.load("image/Hero_Red_.png")
Blue_Tower1 = pygame.image.load("image/Blue_Tower1.png")
Blue_Tower2 = pygame.image.load("image/Blue_Tower2.png")
Blue_Tower3 = pygame.image.load("image/Blue_Tower3.png")
Red_tower1 = pygame.image.load("image/Red_tower1.png")
Red_tower2 = pygame.image.load("image/Red_tower2.png")
Red_tower3 = pygame.image.load("image/Red_tower3.png")
arrow = pygame.image.load("image/bullet.png")
badguyimg1 = pygame.image.load("image/badguy.png")
badguyimg=badguyimg1
healthbar = pygame.image.load("image/healthbar.png")
health = pygame.image.load("image/health.png")
fefeat = pygame.image.load("image/defeat.png")
victory = pygame.image.load("image/victory.png")
#添加声音
# 3.1 - Load audio
hit = pygame.mixer.Sound("audio/explode.wav")
enemy = pygame.mixer.Sound("audio/enemy.wav")
shoot = pygame.mixer.Sound("audio/shoot.wav")
hit.set_volume(0.05)
enemy.set_volume(0.05)
shoot.set_volume(0.05)

#pygame.mixer.music.load("audio/moonlight.wav")
pygame.mixer.music.load("audio/wangzhe.wav")
pygame.mixer.music.play(-1, 0.0)
pygame.mixer.music.set_volume(0.25)


#4
running = 1
exitcode = 0
while running:
    badtimer-=1
    # 5
    screen.fill(0)
    # 6
    screen.blit(bg_haidu,(0,0))
    #screen.blit(Blue_player,(100,100))
    #大一点的小妲己（这个后面的图片会盖在前面的图片上
    screen.blit(Blue_Tower1,(33,227.25))
    screen.blit(Blue_Tower2,(33,391.5))
    screen.blit(Blue_Tower3,(33,555.75))
    screen.blit(Hero_Red_,(1119,30))
    screen.blit(Red_tower1,(1119,227.25))
    screen.blit(Red_tower2,(1119,391.5))
    screen.blit(Red_tower3,(1119,555.75))
    #screen.blit(Hero_Blue_,Hero_Blue_pos)
    
    # 6.1 - Set player position and rotation
    position = pygame.mouse.get_pos()
    angle = math.atan2(position[1]-(Hero_Blue_pos[1]+88),position[0]-(Hero_Blue_pos[0]+80.5))
    Hero_Blue_rot = pygame.transform.rotate(Hero_Blue_, 360-angle*57.29)
    Hero_Blue_pos1 = (Hero_Blue_pos[0]-Hero_Blue_rot.get_rect().width/2, Hero_Blue_pos[1]-Hero_Blue_rot.get_rect().height/2)
    screen.blit(Hero_Blue_rot, Hero_Blue_pos1)
    
    # 6.2 - Draw arrows
    for bullet in arrows:
        index=0
        velx=math.cos(bullet[0])*10  #速度
        vely=math.sin(bullet[0])*10
        bullet[1]+=velx
        bullet[2]+=vely
        #参数991表示不会射出塔
        if bullet[1]<-156 or bullet[1]>991 or bullet[2]<-156 or bullet[2]>720:
            arrows.pop(index)
        index+=1
        for projectile in arrows:
            arrow1 = pygame.transform.rotate(arrow, 360-projectile[0]*57.29)
            screen.blit(arrow1, (projectile[1], projectile[2]))
    
     # 6.3 - Draw badgers
    if badtimer==0:
        badguys.append([1091, random.randint(191,529)])
        badtimer=100-(badtimer1*2)
        if badtimer1>=35:
            badtimer1=35
        else:
            badtimer1+=5
    index=0
    for badguy in badguys:
        # 6.3.1 - Attack castle
        badrect=pygame.Rect(badguyimg.get_rect())
        badrect.top=badguy[1]
        badrect.left=badguy[0]
        if badrect.left<64:
            hit.play()
            healthvalue -= random.randint(5,20)
            badguys.pop(index)
            
        #6.3.2 - Check for collisions
        index1=0
        for bullet in arrows:
            bullrect=pygame.Rect(arrow.get_rect())
            bullrect.left=bullet[1]
            bullrect.top=bullet[2]
            if badrect.colliderect(bullrect):
                enemy.play()
                acc[0]+=1
                badguys.pop(index)
                arrows.pop(index1)
            index1+=1
            
        # 6.3.3 - Next bad guy
        if badguy[0]<-64:
            badguys.pop(index)
        badguy[0]-=7
        index+=1
        
    for badguy in badguys:
        screen.blit(badguyimg, badguy)
        
    # 6.4 - Draw clock
    font = pygame.font.Font(None, 24)#使用PyGame默认的大小为24的字体
    survivedtext = font.render(str((90000-pygame.time.get_ticks())/60000)[:1]+":"+str((90000-pygame.time.get_ticks())/1000%60)[:4].zfill(2), True, (255,255,255))
    #上一行代码使用字符串切片操作保留整数；（255，255，255）把颜色设置为白色
    textRect = survivedtext.get_rect()
    textRect.topright=[1250,5]
    screen.blit(survivedtext, textRect)
    
     # 6.5 - Draw health bar
    screen.blit(healthbar, (5,5))
    for health1 in range(healthvalue):
        screen.blit(health, (health1+8,8))
    
    # 7
    pygame.display.flip()
    # 8
    for event in pygame.event.get():
        #if event.type==pygame.QUIT:
        #    pygame.quit()
        #    exit(0)
        if event.type == pygame.KEYDOWN:
            if event.key==K_w:
                keys[0]=True
            elif event.key==K_a:
                keys[1]=True
            elif event.key==K_s:
                keys[2]=True
            elif event.key==K_d:
                keys[3]=True
        if event.type == pygame.KEYUP:
            if event.key==pygame.K_w:
                keys[0]=False
            elif event.key==pygame.K_a:
                keys[1]=False
            elif event.key==pygame.K_s:
                keys[2]=False
            elif event.key==pygame.K_d:
                keys[3]=False
        #点击鼠标射出箭头
        if event.type==pygame.MOUSEBUTTONDOWN:
            shoot.play()
            position=pygame.mouse.get_pos()
            acc[1]+=1
            arrows.append([math.atan2(position[1]-(Hero_Blue_pos1[1]+88),position[0]-(Hero_Blue_pos1[0]+80.5)),Hero_Blue_pos1[0]+88,Hero_Blue_pos1[1]+80.5])

        
         # 9 - Move player
        if keys[0]:
            Hero_Blue_pos[1]-=5
        elif keys[2]:
            Hero_Blue_pos[1]+=5
        if keys[1]:
            Hero_Blue_pos[0]-=5
        elif keys[3]:
            Hero_Blue_pos[0]+=5
    
        if event.type==pygame.QUIT:
            pygame.quit()
            exit(0)
            
    #10 - Win/Lose check
    if pygame.time.get_ticks()>=90000:
        running=0
        exitcode=1
    if healthvalue<=0:
        running=0
        exitcode=0
    if acc[1]!=0:
        accuracy=acc[0]*1.0/acc[1]*100
        accuracy = round(accuracy,2)#保留小数点后两位
    else:
        accuracy=0
# 11 - Win/lose display        
if exitcode==0:
    pygame.font.init()
    font = pygame.font.Font(None, 24)
    text = font.render("Accuracy: "+str(accuracy)+"%", True, (255,0,0))
    textRect = text.get_rect()
    textRect.centerx = screen.get_rect().centerx
    textRect.centery = screen.get_rect().centery+24
    screen.blit(fefeat, (0,0))
    screen.blit(text, textRect)
else:
    pygame.font.init()
    font = pygame.font.Font(None, 24)
    text = font.render("Accuracy: "+str(accuracy)+"%", True, (0,255,0))
    textRect = text.get_rect()
    textRect.centerx = screen.get_rect().centerx
    textRect.centery = screen.get_rect().centery+24
    screen.blit(victory, (0,0))
    screen.blit(text, textRect)
while 1:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            exit(0)
    pygame.display.flip()